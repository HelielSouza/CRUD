import java.util.Scanner;
import db.dao.StudentsDao;
import db.dbo.StudentDbo;

public class Main{
    public static void main (String[] args) throws Exception{
            
        int option = 0;
        Scanner scanner = new Scanner(System.in);

    do{
        System.out.println("---------------------------------------------------------------");
        System.out.println("Escolha uma opção digitando o número correspondente e pressionando ENTER:\n");
        System.out.println("1. Cadastrar aluno");
        System.out.println("2. Excluir aluno");
        System.out.println("3. Alterar dados do aluno");
        System.out.println("4. Pesquisar por aluno");
        System.out.println("5. Sair do programa");
        System.out.println("\nDigite sua opção: ");      
        option = scanner.nextInt();

        switch(option){
            //insert dados
            case 1: //incluir
                try {
                    int rg = 0, addressNumber = 0;
                    String name = " " , birth, email, course = " ", cell, cep, complement = " ";
                    
                    System.out.println("\n--------- CADASTRO DE ALUNO ---------\n");
                    System.out.println("\nDigite seu RG, somente números (sem espaço, hífen, parentes, ou pontos): ");     
                    rg = scanner.nextInt();                            

                    System.out.println("\nDigite seu NOME completo com as primeiras letras maisculas: ");
                    name = scanner.next()+ " "+ scanner.nextLine(); 
                    
                    System.out.println("\nDigite a data de NASCIMENTO com todos os caracteres, exemplo: xx/xx/xxxx ");
                    birth = scanner.next();                  
                    
                    System.out.println("\nDigite seu EMAIL: ");
                    email = scanner.next();                   
                    
                    System.out.println("\nDigite o nome do CURSO: ");
                    course = scanner.next() + " " + scanner.nextLine();              

                    System.out.println("\nDigite seu TELEFONE (sem espaço, hífen, parentes, ou pontos): ");
                    cell = scanner.next();
                
                    System.out.println("\nDigite seu CEP da sua residência (sem espaço, hífen, parentes, ou pontos): ");
                    cep = scanner.next();                  

                    System.out.println("\nDigite o COMPLEMENTO da sua residencia (se nao tem tiver, so digite 'sem'): ");
                    complement = scanner.next() + " " + scanner.nextLine();                 

                    System.out.println("\nDigite o NÚMERO da sua residência: ");
                    addressNumber = scanner.nextInt();
                 
                    StudentDbo studentRegister = new StudentDbo(rg, name, birth, email, course, cell, cep, complement, addressNumber);
                 
                    StudentsDao.register(studentRegister);
                    System.out.println("\nAluno cadastrado com sucesso");

                } catch (Exception e) {
                    System.out.println("\nErro ao cadastrar aluno: " + e.getMessage());
                }
            break;
                
            case 2: 
                try {                               
                    //aqui preciso arrumar exibindo todos os dados do aluno e perguntando se o usuario tem certeza se deseja realizar a exclusao
                    //Scanner exclusao = new Scanner(System.in);
                    int deleteOption = 0;
                    System.out.println("--------- EXCLUSÃO DE ALUNO ---------");
                    System.out.println("\nDigite o RG do aluno que você deseja excluir: ");
                    int rgToDelete = scanner.nextInt();

                    StudentDbo studentToDelete =  StudentsDao.getStudent(rgToDelete);
                    Address addressToDelete = (Address)ClientWS.getObject(Address.class, 
                        "https://api.postmon.com.br/v1/cep", studentToDelete.getCep());

                        System.out.println("\n--------- DADOS DO ALUNO ---------\n");
                        System.out.println("Nome do aluno: .......... "+studentToDelete.getName());
                        System.out.println("RG: ..................... "+studentToDelete.getRg());   
                        System.out.println("Nascimento: ............. "+studentToDelete.getBirth());
                        System.out.println("Email: .................. "+studentToDelete.getEmail());
                        System.out.println("Curso: .................. "+studentToDelete.getCourse());
                        System.out.println("Telefone: ............... "+studentToDelete.getCellphone());
                        System.out.println("CEP: .................... "+studentToDelete.getCep());
                        System.out.println("Numero da residência: ... "+studentToDelete.getNumber());
                        System.out.println("Complemento: ............ "+studentToDelete.getComplement());
                        System.out.println("Rua: .................... "+addressToDelete.getAddress());
                        System.out.println("Bairro: ................. "+addressToDelete.getNeighborhood());
                        System.out.println("Cidade: ................. "+addressToDelete.getCity());
                        System.out.println("Estado: ................. "+addressToDelete.getState());

                    System.out.println("\nAcima estão os dados do RG selecionado. "+
                                        "\n\nTem certeza que deseja excluir? digite apenas o número:" +
                                        "\n1. para SIM, tenho certeza da exclusão."+
                                        "\n2. para NÃO, não quero excluir.");
                    deleteOption = scanner.nextInt();

                
                    switch (deleteOption){
                        case 1: try {
                            StudentsDao.delete(rgToDelete);
                            System.out.println("\nAluno excluido com sucesso");
                    
                        } catch (Exception e) {
                            System.out.println("\nErro ao excluir aluno\n" + e.getMessage());
                        }
                        break;

                        case 2: 
                            System.out.println("\nExclusão cancelada");
                        break;

                        default: 
                            System.out.println("'\nOpcão inválida, voce sera encaminhado ao MENU.\n");
                        break;
                    }  
                } catch (Exception e) {
                   System.out.println("Erro: "+ e.getMessage());
                }  
            break;
                
            case 3: 
                    //Scanner update = new Scanner(System.in);
                     //alterar 
                    // pedir pro usuario escolher o que ele deseja atualizar e inserir um novo valor a aquilo.
                    // switch case perguntando qual dado ele deseja atualizar, ai fazer na classe dao um metodo para
                    // cada atributo que ela deseja atualizar                  
                    System.out.println("\n--------- ATUALIZAÇÃO DE DADOS ---------");
                    System.out.println("\nDigite o RG do aluno que você deseja alterar: ");
                    int rgToUpdate = scanner.nextInt();
                    try{
                        int optionUpdate = 0;
                        //Scanner Alteracao = new Scanner(System.in);

                        StudentDbo studentToUpdate =  StudentsDao.getStudent(rgToUpdate);
                        Address addressToUpdate = (Address)ClientWS.getObject(Address.class, 
                            "https://api.postmon.com.br/v1/cep", studentToUpdate.getCep());
    
                        System.out.println("\n--------- DADOS DO ALUNO ---------\n");
                        System.out.println("Nome do aluno: .......... "+studentToUpdate.getName());
                        System.out.println("RG: ..................... "+studentToUpdate.getRg());   
                        System.out.println("Nascimento: ............. "+studentToUpdate.getBirth());
                        System.out.println("Email: .................. "+studentToUpdate.getEmail());
                        System.out.println("Curso: .................. "+studentToUpdate.getCourse());
                        System.out.println("Telefone: ............... "+studentToUpdate.getCellphone());
                        System.out.println("CEP: .................... "+studentToUpdate.getCep());
                        System.out.println("Numero da residência: ... "+studentToUpdate.getNumber());
                        System.out.println("Complemento: ............ "+studentToUpdate.getComplement());
                        System.out.println("Rua: .................... "+addressToUpdate.getAddress());
                        System.out.println("Bairro: ................. "+addressToUpdate.getNeighborhood());
                        System.out.println("Cidade: ................. "+addressToUpdate.getCity());
                        System.out.println("Estado: ................. "+addressToUpdate.getState());
    
                        // todos os dados incluindo rua, neighborhood, city e state
                        System.out.println("\nEsses são os dados do RG selecionado.");
                        System.out.println("Você realmente deseja alterar? Digite apenas o número:");
                        System.out.println("\n1. Sim, desejo alterar.");
                        System.out.println("2. Não, quero retornar ao menu.");
                        optionUpdate = scanner.nextInt();
                        
                        switch(optionUpdate){
                            case 1:
                                int whichDataUpdate = 0;
                                System.out.println("\n ----- Qual dado você deseja alterar? -----");
                                System.out.println("\n1. Nome");
                                System.out.println("2. Data de nascimento");
                                System.out.println("3. Email");
                                System.out.println("4. Curso");
                                System.out.println("5. Telefone");
                                System.out.println("6. CEP");
                                System.out.println("7. Número da residência");
                                System.out.println("0. para retornar ao menu");
                                System.out.println("\n<<< Obs: dados não presentes aqui não poderão ser alterados >>>\n");
                                whichDataUpdate = scanner.nextInt();

                                switch(whichDataUpdate){
                                    case 0:
                                        System.out.println("\nVocê retornou ao menu!");
                                    break;
                                        case 1:   
                                                                          
                                            System.out.println("\nDigite o novo nome pelo qual você gostaria de atualizar: \n");
                                            String nameUpdate = scanner.next()+ "" + scanner.nextLine();
                                        try{    
                                            StudentsDao.updateName(rgToUpdate, nameUpdate); 
                                            System.out.println("\nNome atualizado com sucesso");

                                        } catch (Exception e) {
                                            System.out.println("Erro: " + e.getMessage());
                                        }
                                    break;

                                    case 2:
                                        System.out.println("\nDigite sua nova data de nascimento: ");
                                        String birthUpdate = scanner.next() + " " + scanner.nextLine();

                                        try {
                                            StudentsDao.updateBirth(rgToUpdate, birthUpdate);
                                            System.out.println("\nData de nascimento atualizada com sucesso");

                                        } catch (Exception e) {
                                            System.out.println("Erro: " + e.getMessage());
                                        }
                                    break;

                                    case 3:
                                        System.out.println("\nDigite o novo email pelo qual você gostaria de atualizar: ");
                                        String emailUpdate = scanner.next();

                                        try {
                                            StudentsDao.updateEmail(rgToUpdate, emailUpdate);
                                            System.out.println("\nEmail atualizado com sucesso");

                                        } catch (Exception e) {
                                            System.out.println("Erro: " + e.getMessage());
                                        }
                                        
                                    break;

                                    case 4:
                                        System.out.println("\nDigite o novo curso pelo qual você gostaria de atualizar: ");
                                        String courseUpdate = scanner.next() + " " + scanner.nextLine();

                                        try {
                                            StudentsDao.updateCourse(rgToUpdate, courseUpdate);
                                            System.out.println("\nCurso atualizado com sucesso");

                                        } catch (Exception e) {
                                            System.out.println("Erro: " + e.getMessage());
                                        }
                                    break;

                                    case 5:
                                        System.out.println("\nDigite seu novo número de telefone (sem espaço, virgula, ponto ou hífen): ");
                                        String cellphoneUpdate = scanner.next();

                                        try {
                                            StudentsDao.updateCellphone(rgToUpdate, cellphoneUpdate);
                                            System.out.println("\nTelefone atualizado com sucesso");

                                        } catch (Exception e) {
                                            System.out.println("Erro: " + e.getMessage());
                                        }
                                    break;

                                    case 6:
                                        System.out.println("\nDigite o novo CEP (sem hífen, espaço, ponto ou vírgula): ");
                                        String cepUpdate = scanner.next();

                                        try {
                                            StudentsDao.updateCep(rgToUpdate, cepUpdate);
                                            System.out.println("\nCEP atualizado com sucesso");

                                        } catch (Exception e) {
                                            System.out.println("Erro: " + e.getMessage());
                                        }
                                    break;

                                    case 7:
                                        System.out.println("\nDigite o novo número da sua residencia: ");
                                        int numberUpdate = scanner.nextInt();

                                        try {
                                            StudentsDao.updateNumber(rgToUpdate, numberUpdate);
                                            System.out.println("\nNumero atualizado com sucesso");

                                        } catch (Exception e) {
                                            System.out.println("Erro: " + e.getMessage());
                                        }
                                    break;

                                    default: 
                                        System.out.println("\nOpção inválida!");
                                    break;
                                }
                                try {
                                    
                                } catch (Exception e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }
                            break;
                            
                            case 2:
                                System.out.println("\nVocê retornou ao menu!");
                            break;

                            default:
                                System.out.println("\nOpção inválida, voce sera encaminhado ao menu!");
                            break;
                        }
                        
                    }
                    catch (Exception e){
                        System.out.println("\nErro: " + e.getMessage());
                    }
            break;
                
            case 4: //pesquisar
                System.out.println("\n--------- PESQUISA DE ALUNO ---------");
                System.out.println("\nDigite o RG do aluno para pesquisar");
                int rgToSearch = Keyboard.getUmInt();
                try{
                    StudentDbo StudentToSearch =  StudentsDao.getStudent(rgToSearch);
                    Address addressToSearch = (Address)ClientWS.getObject(Address.class, 
                        "https://api.postmon.com.br/v1/cep", StudentToSearch.getCep());

                    System.out.println("\n--------- DADOS DO ALUNO ---------\n");
                    System.out.println("Nome do aluno: .......... "+StudentToSearch.getName());
                    System.out.println("RG: ..................... "+StudentToSearch.getRg());   
                    System.out.println("Nascimento: ............. "+StudentToSearch.getBirth());
                    System.out.println("Email: .................. "+StudentToSearch.getEmail());
                    System.out.println("Curso: .................. "+StudentToSearch.getCourse());
                    System.out.println("Telefone: ............... "+StudentToSearch.getCellphone());
                    System.out.println("CEP: .................... "+StudentToSearch.getCep());
                    System.out.println("Numero da residência: ... "+StudentToSearch.getNumber());
                    System.out.println("Complemento: ............ "+StudentToSearch.getComplement());
                    System.out.println("Rua: .................... "+addressToSearch.getAddress());
                    System.out.println("Bairro: ................. "+addressToSearch.getNeighborhood());
                    System.out.println("Cidade: ................. "+addressToSearch.getCity());
                    System.out.println("Estado: ................. "+addressToSearch.getState()+ "\n");

                    // todos os dados incluindo rua, neighborhood, city e state
                }
                catch (Exception erro){
                    System.err.println (erro.getMessage());
                }
            break;
                
            case 5:
                System.out.println("\n\n------ O programa está encerrado. Obrigado pela preferência! ------\n\n");
                break;             
            default: 
                System.out.println("Opcão inválida");
                break;
            }
        } while(option != 5 );
        scanner.close();
    }
}

