package com.alura.hotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.alura.hotel.controller.HuespedesController;
import com.alura.hotel.controller.NacionalidadController;
import com.alura.hotel.controller.ReservasController;
import com.alura.hotel.modelo.Huespedes;
import com.alura.hotel.modelo.Nacionalidad;
import com.alura.hotel.modelo.Reservas;

/**
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modeloReserva;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	
	private ReservasController reservasController;
	private HuespedesController huespedesController;
	private NacionalidadController nacionalidadController;

	private int tablaActiva;
	private boolean seActualizaron = false;
	
	/**
	 * Lanza la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la ventana.
	 */
	public Busqueda() {
		
		reservasController = new ReservasController();
		huespedesController = new HuespedesController();
		nacionalidadController = new NacionalidadController();

		tablaActiva = 0;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 14));
		modeloReserva = (DefaultTableModel) tbReservas.getModel();
		modeloReserva.addColumn("Numero de Reserva");
		modeloReserva.addColumn("Fecha Check In");
		modeloReserva.addColumn("Fecha Check Out");
		modeloReserva.addColumn("Valor");
		modeloReserva.addColumn("Forma de Pago");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 14));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				tablaActiva = panel.getSelectedIndex();

				if(tablaActiva == 0) {
					listarTablaReservas();
				} else {
					listarTablaHuespedes();
				}
			}	
		});
		
		//Agrega los datos a las tablas
		listarTablaReservas();
		listarTablaHuespedes();
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);		     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		final JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		final JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tablaActiva == 0) {
					buscarPorNumeroReserva();
				} else {
					buscarPorApellido();
				}							
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Esta seguro de editar el item seleccionado?\nTenga en cuenta que la columna de identificación no puede ser alterada", "Confirmar edición", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (showConfirmDialog == 0) {
					if(tablaActiva == 0) {
						modificar(tbReservas, modeloReserva);
						listarTablaReservas();
					} else {
						modificar(tbHuespedes, modeloHuesped);
						listarTablaHuespedes();
					}

				}
			}	
		});
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el item seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if (showConfirmDialog == 0) {
					if(tablaActiva == 0) {
						eliminar(tbReservas, modeloReserva, "la reserva");
						listarTablaReservas();
					} else {
						eliminar(tbHuespedes, modeloHuesped, "el huesped");
						listarTablaHuespedes();
					}
				}
			}	
		});
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}
	
	//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	    xMouse = evt.getX();
	    yMouse = evt.getY();
	 }

	 private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	    int x = evt.getXOnScreen();
	    int y = evt.getYOnScreen();
	    this.setLocation(x - xMouse, y - yMouse);
	 }

	/**
	 * Lista los datos de las tabla reservas
	 * @param reservas
	 */
	private void tablaReservas(List<Reservas> reservas) {
		 modeloReserva.setRowCount(0);
		 
		 reservas.forEach(reserva -> modeloReserva.addRow(
		    		new Object[] {
		    				reserva.getId(),
		    				reserva.getFecha_entrada(),
		    				reserva.getFecha_salida(),
		    				reserva.getValor(),
		    				reserva.getForma_pago()	    				
		    		}));
	 }

	/**
	 * Lista los datos de la tabla huespedes
	 * @param huespedes
	 */
	private void tablaHuespedes(List<Huespedes> huespedes) {
		 modeloHuesped.setRowCount(0);
		 
		 huespedes.forEach(huesped -> modeloHuesped.addRow(
		    		new Object[] {
		    				huesped.getId(),
		    				huesped.getNombre(),
		    				huesped.getApellido(),
		    				huesped.getFecha_nacimiento(),
		    				huesped.getNombre_Nacionalidad(),
		    				huesped.getTelefono(),
		    				huesped.getId_reserva()
		    		}));
	 }


	/**
	 * Envia los datos para listar las tabla reservas
	 */
	private void listarTablaReservas() {
		List<Reservas> reservas = this.reservasController.listar();

		tablaReservas(reservas);
	}

	/**
	 * Envia los datos para listar la tabla huespedes
	 */
	private void listarTablaHuespedes() {
		List<Huespedes> huespedes = this.huespedesController.listar();

		tablaHuespedes(huespedes);
	}

	/**
	 * Permite buscar por apellido en la tabla huespedes
	 */
	private void buscarPorApellido() {
		 try {
			 if(!txtBuscar.getText().equals("")) {
				 List<Huespedes> huespedes = this.huespedesController.listarPorApellido(txtBuscar.getText());
				 
				 tablaHuespedes(huespedes);

				 if (modeloHuesped.getRowCount() == 0) {
					 JOptionPane.showMessageDialog(this, "No se encontro ningun huesped");
					 listarTablaHuespedes();
				 }
			 }
			 else {
				 JOptionPane.showMessageDialog(this, "Por favor ingrese algun apellido en el buscador"); 
			 }
			 
		 } catch (Exception e) {			 
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(this, "Por favor solo ingrese apellidos");
		 }		 
	 }

	/**
	 * Permite buscar por id en la tabla reservas
	 */
	private void buscarPorNumeroReserva() {
		 try {
			 if(!txtBuscar.getText().equals("")) {
				 List<Reservas> reservas = this.reservasController.listarPorId(Integer.valueOf(txtBuscar.getText()));
				 
				 tablaReservas(reservas);

				 if (modeloReserva.getRowCount() == 0) {
					 JOptionPane.showMessageDialog(this, "No se encontro ninguna reserva");
					 listarTablaReservas();
				 }
			 }
			 else {
				 JOptionPane.showMessageDialog(this, "Por favor ingrese algun número de reserva en el buscador"); 
			 }		 
		 } catch (Exception e) {
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(this, "Por favor solo ingrese números de reservas");
		 }	 
	 }

	/**
	 * Verifica si selecciono alguna fila de la tabla
	 * @param tabla
	 * @return
	 */
	private boolean tieneFilaElgida(JTable tabla) {
		 return tabla.getSelectedRowCount() == 0 || tabla.getSelectedColumnCount() == 0;
	 }

	/**
	 * Permite modificar los datos de la tabla reservas
	 * @param tabla
	 * @param modelo
	 */
	private void modificarAtributosTablaModeloReservas(JTable tabla, DefaultTableModel modelo) {
		 var filasModeloReservas = new ReservasController();
		 
		 Integer id = Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
		 Date fecha_entrada = Date.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 1).toString());
		 Date fecha_salida = Date.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 2).toString());
		 Float valor = Float.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
		 String forma_pago = (String) modelo.getValueAt(tabla.getSelectedRow(), 4);
		 
		 
		 if(fecha_entrada.compareTo(fecha_salida) <= 0) {
			 filasModeloReservas.modificar(id, fecha_entrada, fecha_salida, forma_pago, valor);	
			 this.seActualizaron = true;
			 JOptionPane.showMessageDialog(this, "Se actualizaron con exito todos los datos asociados a la reserva");
		 } else {
			JOptionPane.showMessageDialog(this, "La fecha de entrada no puede ser menor a la de salida"); 
		 } 
	 }

	/**
	 * Permite modificar los datos de la tabla huespedes
	 * @param tabla
	 * @param modelo
	 */
	private void modificarAtributosTablaModeloHuespedes(JTable tabla, DefaultTableModel modelo) {
		 var filasModeloHuespedes = new HuespedesController();

		Integer id = Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
		String nombre = (String) modelo.getValueAt(tabla.getSelectedRow(), 1);
		String apellido = (String) modelo.getValueAt(tabla.getSelectedRow(), 2);
		Date fecha_nacimiento = Date.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
		String nacionalidad = (String) modelo.getValueAt(tabla.getSelectedRow(), 4);
		String telefono = (String) modelo.getValueAt(tabla.getSelectedRow(), 5);
		Integer num_reserva = Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 6).toString());

		int numIdNacionalidad = nacionalidadController.buscarPorNombre(nacionalidad);

		if(numIdNacionalidad != 0) {
			if(huespedesController.buscarIdReservaHuesped(id, num_reserva) == 0) {
				if(reservasController.buscarIdReserva(num_reserva) >= 1) {
					filasModeloHuespedes.modificar(id, nombre, apellido, fecha_nacimiento, numIdNacionalidad, telefono, num_reserva);
					this.seActualizaron = true;
				} else {
					JOptionPane.showMessageDialog(this, "El numero de reserva insertado no existe en la base de datos");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Esta reserva ya fue asignada a otro huesped");
			}

		} else {
			JOptionPane.showMessageDialog(this, "Nacionalidad no encontrada por favor vuelve a intentar");
		}
	}

	/**
	 * Realiza las moficaciones de las tablas
	 * @param tabla
	 * @param modelo
	 */
	 private void modificar(JTable tabla, DefaultTableModel modelo) {
		 if(tieneFilaElgida(tabla)) {
			 JOptionPane.showMessageDialog(this, "Por favor seleccione un item de la tabla");
			 return;
		 }
		 
		 Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
		 .ifPresentOrElse(fila -> {
			 
			 if(tablaActiva == 0) {
				 modificarAtributosTablaModeloReservas(tabla, modelo);
			 } else {
				modificarAtributosTablaModeloHuespedes(tabla, modelo);
			 }

			 if (this.seActualizaron == true) {
				 JOptionPane.showMessageDialog(this, "Se actualizaron los datos correctamente");
				this.seActualizaron = false;
			 }

		 }, () -> JOptionPane.showMessageDialog(this, "Por favor, elige un item"));
	 }

	/**
	 * Permite eliminar un registro
	 * @param tabla
	 * @param modelo
	 * @param completarMensaje
	 */
	private void eliminar(JTable tabla, DefaultTableModel modelo, String completarMensaje) {
		 if(tieneFilaElgida(tabla)) {
			 JOptionPane.showMessageDialog(this, "Por favor seleccione un item de la tabla");
			 return;
		 }
		 
		 Optional.ofNullable(modelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn()))
		 .ifPresentOrElse(fila -> {
			 Integer id = Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
			 		 
			 var filasModeloReservas = new ReservasController();
			 var filasModeloHuespedes = new HuespedesController();
			 
			 if(tablaActiva == 0) {
				 filasModeloHuespedes.eliminarConReserva(id);
				 filasModeloReservas.eliminar(id);	
			 } else {
				 filasModeloHuespedes.eliminar(id);
			 }

			 try {
				 modelo.removeRow(tabla.getSelectedRow());
			} catch (Exception e) {
				e.printStackTrace();
			}
			 JOptionPane.showMessageDialog(this, "Se eliminaron con exito todos los datos asociados a " + completarMensaje);
			 
		 }, () -> JOptionPane.showMessageDialog(this, "Por favor, elige un item"));
	 }
}

