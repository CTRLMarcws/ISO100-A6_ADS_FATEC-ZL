package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import persistence.PessoaDao;

public class PessoaController implements ActionListener
{

	private JTextField tfPessoa;
	private JFormattedTextField tfPosicao;
	private JTextArea taLista;
	private PessoaDao pDao;

	public PessoaController(JTextField tfPessoa, JFormattedTextField tfPosicao, JTextArea taLista)
	{
		this.tfPessoa = tfPessoa;
		this.tfPosicao = tfPosicao;
		this.taLista = taLista;
		pDao = new PessoaDao();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand(); //Traz o texto do botão pressionado

		if (cmd.equals("Adicionar"))
		{
			adicionar(tfPessoa.getText());
		}

		if (cmd.equals("Excluir"))
		{
			int posicao = Integer.parseInt(tfPosicao.getText());
			excluir(posicao);
		}

		if (cmd.equals("Consultar"))
		{
			int posicao = Integer.parseInt(tfPosicao.getText());
			consultar(posicao);
		}

		if (cmd.equals("Atualizar"))
		{
			int posicao = Integer.parseInt(tfPosicao.getText());
			String pessoa = tfPessoa.getText();
			atualizar(pessoa, posicao);
		}
	}

	private void adicionar(String pessoa)
	{
		
		String retorno = pDao.adicionarPessoa(pessoa);

		paneRetorno(retorno, "inserida");
		
		tfPessoa.setText("");
		listar();
	}

	private void excluir(int posicao)
	{
		String retorno = pDao.excluirPessoa(posicao);
		paneRetorno(retorno, "excluido");
		tfPosicao.setText("0");
		listar();
	}

	private void consultar(int posicao)
	{
		String pessoa = pDao.consultarPessoa(posicao);
		if (pessoa.contains("inexistente"))
		{
			JOptionPane.showMessageDialog(null, pessoa, "ERRO", JOptionPane.ERROR_MESSAGE);
			tfPessoa.setText("");
			tfPosicao.setText("0");	
		}
		else
		{
			tfPessoa.setText(pessoa);
			tfPosicao.setText("0");			
		}

	}
	
	private void listar()
	{
		String [] pessoas = pDao.listarPessoas();
		StringBuffer buffer = new StringBuffer();
		
		for (String pessoa : pessoas)
		{
			buffer.append(pessoa);
			buffer.append("\n");
		}
		
		taLista.setText(buffer.toString());
	}
	
	private void atualizar(String pessoa, int posicao)
	{
		String retorno = pDao.atualizarPessoa(pessoa, posicao);

		paneRetorno(retorno, "atualizado");

		tfPessoa.setText("");
		tfPosicao.setText("0");
		listar();
	}
	
	private void paneRetorno(String retorno, String contem)
	{
		if (retorno.contains(contem))
		{
			JOptionPane.showMessageDialog(null, retorno, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, retorno, "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
