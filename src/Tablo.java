import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Tablo extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private JTable table2;
	private JTable table3;
	int rowValue, columnValue, minValue, maxValue;
	DefaultTableModel model1 = new DefaultTableModel();
	DefaultTableModel model2 = new DefaultTableModel();
	DefaultTableModel model3 = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablo frame = new Tablo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tablo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner rowValueSpinner = new JSpinner();
		rowValueSpinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		rowValueSpinner.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rowValueSpinner.setBounds(71, 25, 66, 31);
		contentPane.add(rowValueSpinner);
		
		JLabel lblRow = new JLabel("Row: ");
		lblRow.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblRow.setBounds(10, 24, 66, 31);
		contentPane.add(lblRow);
		
		JLabel lblColumn = new JLabel("Column: ");
		lblColumn.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblColumn.setBounds(159, 24, 88, 31);
		contentPane.add(lblColumn);
		
		JSpinner columnValueSpinner = new JSpinner();
		columnValueSpinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		columnValueSpinner.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		columnValueSpinner.setBounds(257, 25, 66, 31);
		contentPane.add(columnValueSpinner);
		
		JButton btnNewButton = new JButton("OLUSTUR");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(391, 17, 137, 46);
		contentPane.add(btnNewButton);
		
		JSpinner minValueSpinner = new JSpinner();
		minValueSpinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(5)));
		minValueSpinner.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		minValueSpinner.setBounds(692, 25, 66, 31);
		contentPane.add(minValueSpinner);
		
		JSpinner maxValueSpinner = new JSpinner();
		maxValueSpinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(5)));
		maxValueSpinner.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		maxValueSpinner.setBounds(793, 25, 66, 31);
		contentPane.add(maxValueSpinner);
		
		JLabel lblAralik = new JLabel("Aralik: ");
		lblAralik.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAralik.setBounds(604, 24, 78, 31);
		contentPane.add(lblAralik);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 310, 310);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		table1.setTableHeader(null);
		scrollPane.setViewportView(table1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(330, 92, 310, 310);
		contentPane.add(scrollPane_1);
		
		table2 = new JTable();
		table2.setTableHeader(null);
		scrollPane_1.setViewportView(table2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(650, 92, 310, 310);
		contentPane.add(scrollPane_2);
		
		table3 = new JTable();
		table3.setTableHeader(null);
		scrollPane_2.setViewportView(table3);
		
		JLabel lblNewLabel = new JLabel("MUSTAFA ERCAN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(257, 413, 453, 41);
		contentPane.add(lblNewLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minValue = (int) minValueSpinner.getValue();
				maxValue = (int) maxValueSpinner.getValue();
				rowValue = (int) rowValueSpinner.getValue();
				columnValue = (int) columnValueSpinner.getValue();
				
				model1.setColumnCount(columnValue);
				model1.setRowCount(rowValue);
				model2.setColumnCount(columnValue);
				model2.setRowCount(rowValue);
				model3.setColumnCount(columnValue);
				model3.setRowCount(rowValue);
				
				int[][] m1 = Matris.matrisUret(rowValue, columnValue, minValue, maxValue);
				int[][] m2 = Matris.matrisUret(rowValue, columnValue, minValue, maxValue);
				int[][] m3 = Matris.matrisTopla(m1, m2, rowValue, columnValue);

				
				for(int i=0; i<rowValue; i++) {
					for(int j=0; j<columnValue; j++) {
						model1.setValueAt(m1[i][j], i, j);
						model2.setValueAt(m2[i][j], i, j);
						model3.setValueAt(m3[i][j], i, j);
					}
				}
				table1.setModel(model1);
				table2.setModel(model2);
				table3.setModel(model3);
				
				
			}
		});
		
		
		
		
		
		
	}
}
