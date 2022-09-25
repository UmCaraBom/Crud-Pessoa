package repositorio;

import java.util.List;

import entidade.Pessoa;

public interface IrepositorioPessoa {

    public boolean salvar(Pessoa pessoa);
    public boolean atualizar(Pessoa pessoa);
    public boolean deletar(int id);
    public Pessoa buscarPorId(long id);
    public List<Pessoa> buscarTodos();
}
