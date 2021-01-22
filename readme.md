Instruções de como executar os testes

Pré-condições:
- Possuir o JDK 8 e Maven instalados e configurados.
- Baixar o projeto "cucumber-project", abrir o prompt de comando no diretório raiz do projeto onde está localizado o arquivo pom.xml
- Executar o comando:
mvn -Dbrowser=chrome clean test

Valores possíveis para a variável Dbrowser: chrome, firefox ou edge.
Se não for informada a variável -Dbrowser, o projeto assume o chrome como browser padrão.

- Ao final da execução será gerada URL para acessar o relatório de execução dos testes

OBS 1: É necessário que o navegador que deseja realizar a execução esteja instalado no ambiente.
OBS 2: Execução em ambientes Linux pode ser necessário dar permissão de escrita no diretório do projeto.
ex: sudo chmod 755 -Rfv cucumber-project/
