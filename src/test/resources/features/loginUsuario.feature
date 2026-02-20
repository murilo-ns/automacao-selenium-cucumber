#language: pt

@login
Funcionalidade: Login no sistema
  Eu como usuário da loja online
  quero realizar login na aplicação
  para acessar as funcionalidades da loja virtual

  @login-sucesso
  Cenário: Login com sucesso
    Dado que existe um usuário válido no sistema
    E que estou na tela de login
    Quando realizo o login
    Então o login deve ser realizado com sucesso