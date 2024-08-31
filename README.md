# Projeto Spring Boot API com Deploy na AWS

## Descrição do Projeto

Este projeto é uma API desenvolvida em Java usando o framework Spring Boot. A API interage com um banco de dados PostgreSQL, que está sendo executado em um contêiner Docker. O deploy da aplicação será realizado na AWS, utilizando serviços como EC2, RDS, VPC e S3, proporcionando um ambiente robusto, escalável e seguro.

## Ferramentas e Tecnologias Usadas

### Tecnologias de Desenvolvimento

- **Java 22**: Linguagem de programação usada para desenvolver a API.
- **Spring Boot**: Framework que facilita a criação de aplicações Spring, com configuração mínima.
- **Docker**: Ferramenta para criar, implantar e executar aplicações em contêineres. Usado para executar o PostgreSQL de forma isolada.

### Banco de Dados

- **PostgreSQL**: Banco de dados relacional usado para armazenar os dados da aplicação. Está rodando em um contêiner Docker durante o desenvolvimento.

### AWS (Amazon Web Services)

- **EC2 (Elastic Compute Cloud)**: Serviço que oferece capacidade de computação na nuvem. Será usado para hospedar a aplicação Spring Boot.
    - **Configuração**: A instância EC2 será configurada para rodar a aplicação Java com o Spring Boot, com regras de segurança configuradas para permitir acesso às portas necessárias.

- **RDS (Relational Database Service)**: Serviço gerenciado de banco de dados. O PostgreSQL será migrado para uma instância RDS na AWS para produção.
    - **Benefícios**: O RDS facilita o gerenciamento do banco de dados, com backups automatizados, replicação e recuperação de desastres.

- **VPC (Virtual Private Cloud)**: Rede virtual que isola os recursos da AWS. Será configurada para fornecer um ambiente seguro e isolado onde a instância EC2 e o RDS operam.
    - **Subnets**: A VPC terá sub-redes públicas e privadas para separar a aplicação e o banco de dados.
    - **Security Groups**: Configurações de segurança que definem as regras de entrada e saída para controlar o tráfego para os recursos na VPC.

- **S3 (Simple Storage Service)**: Serviço de armazenamento escalável para arquivos. Pode ser usado para armazenar arquivos estáticos, logs ou backups do banco de dados.
    - **Integração**: A aplicação pode enviar e recuperar arquivos do S3 conforme necessário.

### Gerenciamento de Configuração

- **AWS IAM (Identity and Access Management)**: Gerenciamento de acesso seguro aos serviços e recursos da AWS. IAM roles e policies serão configurados para garantir que apenas as instâncias e serviços apropriados possam interagir entre si.

### CI/CD

- **GitHub Actions**: Automatização de pipelines de build, teste e deploy, integrada ao repositório GitHub do projeto. Pode ser configurado para realizar o deploy automático na AWS após o sucesso nos testes.

## Estrutura do Projeto

```plaintext
src/
├── main/
│   ├── java/com/example/demo/  # Pacote principal da aplicação
│   ├── resources/              # Arquivos de configuração (application.properties, etc.)
├── test/                       # Testes unitários e de integração
Dockerfile                      # Instruções para criar a imagem Docker da aplicação
docker-compose.yml              # Definição dos serviços Docker (ex: PostgreSQL)
pom.xml                         # Dependências Maven
README.md                       # Documentação do projeto
```

## Configuração e Deploy

### Pré-requisitos

1. **Java 22**: Instalar o JDK apropriado.
2. **Maven**: Ferramenta de build para gerenciar as dependências e o ciclo de vida do projeto.
3. **Docker**: Para rodar o PostgreSQL em contêiner durante o desenvolvimento.
4. **AWS CLI**: Interface de linha de comando da AWS, necessária para configurar e gerenciar os serviços da AWS.

### Configuração Local

1. **Configurar o Docker**:
    - Rodar o comando `docker-compose up` para iniciar o contêiner PostgreSQL.

2. **Configurar o Spring Boot**:
    - Configurar o arquivo `application.properties` para apontar para o banco de dados PostgreSQL no Docker.

### Deploy na AWS

1. **Criar e Configurar uma Instância EC2**:
    - Utilizar o AWS Management Console ou CLI para criar uma instância EC2.
    - Configurar as regras de segurança para permitir o tráfego HTTP/HTTPS e acesso SSH.
    - Deployar a aplicação na instância EC2.

2. **Migrar Banco de Dados para RDS**:
    - Criar uma instância RDS com PostgreSQL.
    - Configurar a aplicação para se conectar ao RDS, atualizando as credenciais e a URL do banco de dados no `application.properties`.

3. **Configurar a VPC**:
    - Criar uma VPC com sub-redes públicas e privadas.
    - Configurar o routing e as regras de segurança para proteger os recursos.

4. **Configurar o S3 (Opcional)**:
    - Criar um bucket S3 para armazenamento de arquivos.
    - Configurar permissões e políticas de acesso.

### Testes e Monitoramento

- **CloudWatch**: Serviço de monitoramento da AWS para acompanhar logs e métricas da aplicação.
- **Elastic Load Balancing (ELB)**: Opcionalmente, configurar um load balancer para distribuir o tráfego entre múltiplas instâncias EC2.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.
