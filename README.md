# 🪙 Currency Converter - Challenge ONE
> **Status do Projeto:** Concluído ✅

Este é um conversor de moedas robusto desenvolvido em **Java 21**, focado em praticar o consumo de APIs REST, manipulação de dados JSON e princípios de Clean Code. O projeto faz parte do desafio *Back-end Java* do programa **ONE (Oracle Next Education)**.

---

## 🌟 Diferenciais desta Versão
Diferente de implementações básicas, este projeto foi refatorado para seguir padrões modernos de desenvolvimento, unindo a lógica de programação com boas práticas de QA:

* **Arquitetura Limpa:** Separação clara entre lógica de negócio, configuração e interface.
* **Segurança:** Uso de variáveis de ambiente para proteção da API Key.
* **Robustez (QA Ready):** Validação de entradas do usuário para evitar *crashes* por tipos de dados inválidos.
* **UX Aprimorada:** Interface de console com símbolos monetários (R$, $, €), separadores visuais e *delays* para melhor leitura dos resultados.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Descrição |
| :--- | :--- |
| **Java 21** | Uso de *Records*, *Switch Expressions* e *Try-with-resources*. |
| **Maven** | Gestão de dependências e automação de build. |
| **Gson (Google)** | Biblioteca para serialização e desserialização de JSON. |
| **ExchangeRate-API** | Fonte de dados para taxas de câmbio em tempo real. |

---

## 🚀 Como Executar o Projeto

### 1. Requisitos
* Java JDK 21 ou superior.
* Maven instalado.
* Uma chave de API da [ExchangeRate-API](https://www.exchangerate-api.com/).

### 2. Configuração da API Key
Para manter a segurança, o sistema busca a chave em uma variável de ambiente. Configure-a no seu terminal:

```bash
# No Windows (PowerShell)
$env:MINHA_API_KEY = "sua_chave_aqui"

# No Linux/Mac
export MINHA_API_KEY="sua_chave_aqui"
```

### 3. Build e Execução
```bash
# Clonar o repositório
git clone https://github.com/WallissonLP/Challenge-Conversor-de-Moedas.git

# Acessar a pasta
cd Challenge-Conversor-de-Moedas

# Compilar e rodar
mvn clean install
mvn exec:java -Dexec.mainClass="br.com.conversor.Principal"
```

---

## 📂 Estrutura de Arquivos
A organização segue o padrão **Maven (src/main/java)**:

* `Principal.java`: Ponto de entrada, gerencia o fluxo de interface e entrada de dados.
* `ConsultaMoeda.java`: Responsável pelas requisições HTTP e integração com a API.
* `DadosMoeda.java`: Record imutável para mapear a resposta JSON.
* `ExchangeApiConfig.java`: Centraliza as configurações de URL e credenciais.

---

## 📸 Exemplo de Output
```text
------------------------------------------
        RESULTADO DA CONVERSÃO            
------------------------------------------
Valor original:   $ 100,00 [USD]
Taxa de câmbio:  5,4832
Valor convertido: R$ 548,32 [BRL]
------------------------------------------
```

---

## 👨‍💻 Autor
**Wallisson de Lima Parreira**
> Analista de QA focado em automação e desenvolvimento Java.

<a href="https://www.linkedin.com/in/wallissonlima/" target="_blank">
  <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn">
</a>

<a href="https://github.com/WallissonLP" target="_blank">
  <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white" alt="GitHub">
</a>