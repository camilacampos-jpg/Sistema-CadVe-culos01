import java.util.ArrayList;
import java.util.List;

List<String> veiculos = new ArrayList<>();

void main() {
    IO.println("Bem vindo ao Sistema CadVeiculos01!");
    String menu = """
            MENU DE OPÇÕES
            1 - Cadastrar Veículo
            2 - Listar Veículos
            3 - Remover Veículo por Índice
            4 - Remover Veículo por Nome
            5 - Buscar Veículo
            6 - Editar Veículo
            0 - Sair
            """;

    int opcao;
    do {
        IO.println(menu);
        opcao = input.scanInt("Digite a opção desejada: ");
        switch (opcao) {
            case 1 -> {
                cadastrar();
                IO.readln("Pressione ENTER para continuar...");
            }
            case 2 -> {
                listar();
                IO.readln("Pressione ENTER para continuar...");
            }
            case 3 -> {
                excluirPorIndice();
                IO.readln("Pressione ENTER para continuar...");
            }
            case 4 -> {
                excluirPorNome();
                IO.readln("Pressione ENTER para continuar...");
            }
            case 5 -> {
                buscar();
                IO.readln("Pressione ENTER para continuar...");
            }
            case 6 -> {
                editar();
                IO.readln("Pressione ENTER para continuar...");
            }
            case 0 -> {
                IO.println("Aguardamos você em uma próxima oportunidade. Volte sempre!");
            }
            default -> {
                IO.println("Opção não encontrada, verifique e tente novamente!");
                IO.readln("Pressione ENTER para continuar...");
            }
        }
    } while (opcao != 0);
}

//Cadastrar

void cadastrar() {
    String veiculo = IO.readln("Digite o nome do veiculo: ");

    veiculo = veiculo.trim();
    if (veiculo.isEmpty())
        IO.println("Nome do veiculo invalido!");
    else 
        veiculos.add(veiculo);
}

//Listar 

void listar() {
    IO.println("\n=== Lista de Veículos ===");
   
   
    if (veiculos.isEmpty()) {
        IO.println("Nenhum veículo cadastrado.");
        return;
    }

//Ordenar

    ordenar();

    for (int i = 1; i <= veiculos.size(); i++) {
        IO.println(i + " - " + veiculos.get(i - 1));
    }

    IO.println("Total de veículos cadastrados: " + veiculos.size());
}

//Buscar por nome 

void buscar() {
    if (veiculos.isEmpty()) {
        IO.println("Nenhum veículo cadastrado.");
        return;
    }

    String nome = IO.readln("Digite o nome do veículo a buscar: ").trim();
    boolean localizado = false;

    for (int i = 0; i < veiculos.size(); i++) {
        if (veiculos.get(i).equalsIgnoreCase(nome)) {
            localizado = true;
            break;
        }
    }

    if (localizado)
        IO.println("Veículo \"" + nome + "\" encontrado na lista!");
    else
        IO.println("Veículo \"" + nome + "\" não encontrado.");

    IO.println("Total de veículos cadastrados: " + veiculos.size());

    ordenar();
    IO.println("\n=== Lista atual ===");
    for (int i = 1; i <= veiculos.size(); i++) {
        IO.println(i + " - " + veiculos.get(i - 1));
    }
}

//Remover por índice 

void excluirPorIndice() {
    listar();

    if (veiculos.isEmpty())
        return;

    int indice = input.scanInt("Digite o índice do veículo a ser removido: ");

    if (indice <= 0 || indice > veiculos.size()) {
        IO.println("Registro de veículo não encontrado!");
    } else {
        String removido = veiculos.get(indice - 1);
        veiculos.remove(indice - 1);
        IO.println("Veículo \"" + removido + "\" removido com sucesso!");
    }
}

//Remover por nome

void excluirPorNome() {
    if (veiculos.isEmpty()) {
        IO.println("Veículo não identificado!");
        return;
    }

    String nome = IO.readln("Digite o nome do veículo a ser removido: ").trim();
    boolean encontrado = false;

    for (int i = 0; i < veiculos.size(); i++) {
        if (veiculos.get(i).equalsIgnoreCase(nome)) {
            veiculos.remove(i);
            IO.println("Veículo \"" + nome + "\" removido com sucesso!");
            encontrado = true;
            break;
        }
    }

    if (!encontrado)
        IO.println("Veículo \"" + nome + "\" não encontrado.");
}
// Editar 

void editar() {
    listar();

    if (veiculos.isEmpty())
        return;

    int indice = input.scanInt("Digite o índice do veículo a ser editado: ");

    if (indice <= 0 || indice > veiculos.size()) {
        IO.println("Veículo não consta no sistema!");
        return;
    }

    String novoNome = IO.readln("Digite o novo nome: ").trim();

    if (novoNome.isEmpty()) {
        IO.println("Nome do veículo não reconhecido!");
        return;
    }

    String nomeAtual = veiculos.get(indice - 1);
    for (int i = 0; i < veiculos.size(); i++) {
        if (!veiculos.get(i).equalsIgnoreCase(nomeAtual) && veiculos.get(i).equalsIgnoreCase(novoNome)) {
            IO.println("Este nome já está em uso por outro veículo! \"" + novoNome + "\"!");
            return;
        }
    }

    veiculos.set(indice - 1, novoNome);
    IO.println("Atualização do veículo realizada \"" + novoNome + "\" com sucesso!");
}

// Ordenar Bubble Sort
void ordenar() {
    for (int i = 0; i < veiculos.size() - 1; i++) {
        for (int j = 0; j < veiculos.size() - 1 - i; j++) {
            String stringaux = veiculos.get(j);
            if (stringaux.compareToIgnoreCase(veiculos.get(j + 1)) > 0) {
                veiculos.set(j, veiculos.get(j + 1));
                veiculos.set(j + 1, stringaux);
            }
        }
    }
}