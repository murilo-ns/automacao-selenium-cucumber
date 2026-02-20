#language: pt

  @cadastro
  Funcionalidade: Cadastro de usuários
    Eu como usuário que está acessando uma loja online
    quero me cadastrar na aplicação
    para ter acesso as funcionalidades da loja virtual

    @cadastro-sucesso
  Cenário: Registrar novo usuário com sucesso
    Dado que estou na tela de cadastro de usuários
    Quando preencher o formulário de cadastro com dados válidos nos campos obrigatórios
    Então ao submeter os dados recebo a confirmação que os dados foram salvos com sucesso