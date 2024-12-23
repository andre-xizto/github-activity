# GitHub Activity CLI

GitHub Activity CLI é uma ferramenta simples desenvolvida em Java que permite visualizar os últimos eventos de um usuário do GitHub diretamente do terminal.

## Funcionalidades

- Solicita o nome de usuário do GitHub.
- Lista os últimos eventos públicos desse usuário.

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **HTTP Client**: Para realização de requisições à API do GitHub.
- **JSON Parsing**: Para interpretar os dados retornados pela API.

## Como Usar

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) instalado em sua máquina (versão 11 ou superior).
2. Clone este repositório:

   ```bash
   git clone https://github.com/andre-xizto/github-activity.git
   ```

3. Navegue até o diretório do projeto:

   ```bash
   cd github-activity
   ```

4. Compile o projeto:

   ```bash
   mvn compile
   ```

5. Execute a aplicação:

   ```bash
   java -cp .\target\classes\ dev.buskopan.Main
   ```

6. Insira o nome de usuário do GitHub quando solicitado.

## Contribuição

Sinta-se à vontade para contribuir com melhorias, seja corrigindo bugs ou adicionando novas funcionalidades. Para contribuir:

1. Faça um fork deste repositório.
2. Crie uma nova branch:
   ```bash
   git checkout -b minha-nova-feature
   ```
3. Faça suas modificações e faça commit:
   ```bash
   git commit -m "Adiciona nova funcionalidade X"
   ```
4. Envie suas modificações:
   ```bash
   git push origin minha-nova-feature
   ```
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

Esperamos que esta ferramenta seja útil para você! Caso tenha dúvidas ou sugestões, entre em contato através da [seção de Issues](https://github.com/andre-xizto/github-activity/issues).