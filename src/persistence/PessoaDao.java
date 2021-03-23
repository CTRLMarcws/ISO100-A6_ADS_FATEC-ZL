package persistence;

public class PessoaDao
{
	private String pessoas [] = new String [10];

	private int proximaPosicao()
	{
		int tamanho = pessoas.length;

		for (int i = 0; i < tamanho; i++)
		{
			if(pessoas[i] == null)
			{
				return i;
			}
		}
		return tamanho;
	}


	public String adicionarPessoa(String pessoa)
	{
		if (pessoa.isBlank())
		{
			return "                Campo vazio,\nInsira o nome a ser cadastrado.";
		}
		else
		{
			int proximaPosicao = proximaPosicao();

			if (proximaPosicao < pessoas.length)
			{
				pessoas[proximaPosicao] = pessoa;
				return "Pessoa inserida!";
			}
			else
			{
				return "Base de dados cheia!";
			}			
		}

	}

	public String excluirPessoa(int posicao)
	{
		int tamanho = pessoas.length;

		if (pessoas[posicao] != null)
		{
			for(int i = (posicao + 1); i < tamanho; i++)
			{
				pessoas[i - 1] = pessoas[i];
			}

			pessoas[tamanho - 1] = null;

			return "Cadastro excluido.";
		}
		return "Posição inexistente.";						

	}

	public String consultarPessoa(int posicao)
	{
		if (pessoas[posicao] != null)
		{
			return pessoas[posicao];			
		}
		return "Posição inexistente.";						
	}

	public String[] listarPessoas()
	{
		int proximaPosicao = proximaPosicao();

		String pessoasAux [] = new String [proximaPosicao];

		for (int i = 0; i < proximaPosicao; i++)
		{
			pessoasAux[i] = pessoas[i];
		}

		return pessoasAux;
	}

	public String atualizarPessoa(String pessoa, int posicao)
	{
		int tamanho = pessoas.length;

		if (pessoas[posicao] != null)
		{
			if (pessoa.isBlank())
			{
				return "    Campo vazio,\nInsira o novo nome.";
			}
			else
			{
				if (posicao < tamanho)
				{
					pessoas[posicao] = pessoa;
					return "Nome atualizado!";
				}
				return "Posição inexistente.";
			}			
		}
		return "Posição ainda não preenchida.";

	}
}
