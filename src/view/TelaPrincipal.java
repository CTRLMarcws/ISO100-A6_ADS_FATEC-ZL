package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import controller.PessoaController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfPessoa;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 480); //Tamanho e posição
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfPessoa = new JTextField();
		tfPessoa.setBounds(90, 45, 434, 20);
		contentPane.add(tfPessoa);
		tfPessoa.setColumns(10);
		
		JLabel lblPessoa = new JLabel("Nome");
		lblPessoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPessoa.setBounds(10, 45, 70, 20);
		contentPane.add(lblPessoa);
		
//		Mascara para o JFormattedTextField
		NumberFormat numberFormat = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(numberFormat);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(99);
		formatter.setAllowsInvalid(false);
		
		JFormattedTextField tfPosicao = new JFormattedTextField(formatter);
		tfPosicao.setText("0");
		tfPosicao.setBounds(90, 91, 70, 20);
		contentPane.add(tfPosicao);
		
		JLabel lblPosicao = new JLabel("Posi\u00E7\u00E3o");
		lblPosicao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPosicao.setBounds(10, 91, 70, 20);
		contentPane.add(lblPosicao);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(10, 153, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(152, 153, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(294, 153, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(435, 153, 89, 23);
		contentPane.add(btnAtualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 203, 514, 227);
		contentPane.add(scrollPane);
		
		JTextArea taLista = new JTextArea();
		scrollPane.setViewportView(taLista);
		
		PessoaController pessoaController = new PessoaController(tfPessoa, tfPosicao, taLista);
		
		JLabel lblNewLabel = new JLabel("Vetor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		JLabel lblTitulo = new JLabel("Cadastro de Pessoas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(10, 11, 514, 23);
		contentPane.add(lblTitulo);
		
		btnAdicionar.addActionListener(pessoaController);
		btnExcluir.addActionListener(pessoaController);
		btnConsultar.addActionListener(pessoaController);
		btnAtualizar.addActionListener(pessoaController);
	}
}
