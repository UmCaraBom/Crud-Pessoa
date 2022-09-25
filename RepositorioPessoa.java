package repositorio;

import java.util.ArrayList;
import java.util.List;

import entidade.Pessoa;

public class RepositorioPessoa implements IrepositorioPessoa {

    List<Pessoa> ListaPessoa = new ArrayList<Pessoa>();

    @Override
    public boolean salvar(Pessoa pessoa) {
        try {
            ListaPessoa.add(pessoa);
            return true;
        } catch (Exception e) {
            return false;}
    }

    @Override
    public boolean atualizar(Pessoa pessoa) {
        try {
            for (Pessoa p : ListaPessoa) {
                if (p.getId() == pessoa.getId()) {
                    p.setNome(pessoa.getNome());
                    p.setCpf(pessoa.getCpf());
                    p.setIdade(pessoa.getIdade());
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deletar(int id) {
        try {
            for (Pessoa p : ListaPessoa) {
                if (p.getId() == id) {
                    ListaPessoa.remove(p);
                    return true;
                }
            }
            return false;
        } catch (Exception e) 
        {return false;}
    }

    @Override
    public Pessoa buscarPorId(long id) {
        //busca por id na lista de pessoas e retorna a pessoa, usando try catch para evitar erros
        try {
            for (Pessoa p : ListaPessoa) {
                if (p.getId() == id) {
                    return p;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Pessoa> buscarTodos() {
        return ListaPessoa;
    }

}
