    import entidade.Pessoa;
import repositorio.RepositorioPessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
    static RepositorioPessoa rp = new RepositorioPessoa();
    public static void main(String[] args) {
        //adicionarPessoas();
        //rp.deletar(1);
        //rp.buscarPorId(3);
        //buscarTodos();
        //atualizar();
        //buscarTodos();
do {
            System.out.println("1 - Adicionar usuário");
            System.out.println("2 - Atualizar usuário");
            System.out.println("3 - Deletar usuário por ID");
            System.out.println("4 - Buscar por ID");
            System.out.println("5 - Buscar todos usuários");
            System.out.println("6 - Sair");
            System.out.println("Digite a opção desejada: ");
            System.out.println("-----------------------------");
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    adicionarPessoas();
                    break;
                case 2:
                    atualizar();
                    break;
                case 3:
                    deletar();
                    break;
                case 4:
                    buscarPorId();
                    break;
                case 5:
                    buscarTodos();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (true);
    }
     
    private static void buscarPorId() {
        System.out.println("Digite o ID da pessoa que deseja buscar: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Pessoa p = rp.buscarPorId(id);
        System.out.println(">> "+p.getId() + " - " + p.getNome() + " - " + p.getCpf() + " - " + p.getIdade());
    }
    private static void deletar() {
        System.out.println("Digite o ID da pessoa que deseja deletar: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        rp.deletar(id);
    }
    //adicionando pessoas
    public static void adicionarPessoas() {
        Pessoa p1 = new Pessoa(1, "João", "123456789", 20);
        Pessoa p2 = new Pessoa(2, "Maria", "987654321", 25);
        Pessoa p3 = new Pessoa(3, "José", "123456789", 30);
        rp.salvar(p1);
        rp.salvar(p2);
        rp.salvar(p3);
    }
    //método para deletar por id com entrada do usuário
    public static void deletarPorId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o id da pessoa que deseja deletar: ");
        int id = sc.nextInt();
        rp.deletar(id);
    }
        //método para atualizar uma pessoa
        public static void atualizar(){
            Pessoa pessoa = new Pessoa();
            //criar scanner para pegar os dados da pessoa
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o id da pessoa que deseja atualizar: ");
            long id = sc.nextLong();
            System.out.println("Digite o nome da pessoa: ");
            String nome = sc.next();
            System.out.println("Digite o cpf da pessoa: ");
            String cpf = sc.next();
            System.out.println("Digite a idade da pessoa: ");
            int idade = sc.nextInt();
            //setar os dados da pessoa
            pessoa.setId(id);
            pessoa.setNome(nome);
            pessoa.setCpf(cpf);
            pessoa.setIdade(idade);
            //atualizar a pessoa
            rp.atualizar(pessoa);
        }
    //método para listar todos os registros
    public static void buscarTodos(){
        List<Pessoa> lista = new ArrayList<Pessoa>();
        lista = rp.buscarTodos();
        //for each para percorrer a lista de pessoas e imprimir o nome e o cpf
        for (Pessoa pessoa : lista) {
            System.out.println("ID: "+pessoa.getId()+" >> "+"Nome: "+pessoa.getNome());
            System.out.println("--------------------------------");
        }
    }
}
