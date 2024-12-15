## 🎯 Propósito do Projeto

O projeto é uma iniciativa da Hackathon de Dezembro de 2024 da Turma 4 do **Programa 1000Devs** pela [mesttra](https://www.mesttra.com/) em parceria com a [Johnson & Johnson Medtech](https://www.jnjmedtech.com/pt-br) e o [Hospital Israelita Albert Einstein](https://www.einstein.br/n/). O Professor [Rogério de Freitas](https://www.linkedin.com/in/rogerio-freitas-ribeiro-690a9712/) organizou o evento para ser um Jogo da Velha com desafios técnicos e de lógica, onde os participantes devem integrar as funcionalidades em equipe.

## 📚 Conceito
é um projeto colaborativo que une aprendizado prático e trabalho em equipe. Ele foi desenvolvido para aplicar e testar conceitos amplamente utilizados no mercado de tecnologia, proporcionando uma experiência rica em desenvolvimento de habilidades técnicas e interpessoais.

## 🛠️ Tecnologias Utilizadas

- ![Java](https://img.shields.io/badge/Java-21-red) - Linguagem de programação utilizada
- ![Maven](https://img.shields.io/badge/Maven-4.0-blue) - Gerenciador de dependências
- ![Jansi](https://img.shields.io/badge/Jansi-2.4.1-white) - Gerenciamento de Cores do CLI
- ![CLI](https://img.shields.io/badge/CLI-Interface-Informática) - Interface de linha de comando utilizada para interação com o jogo


## 🌐 Funcionalidades
- **Jogue contra o Computador** - Permite qvocê jogue contre a máquina uma partida de Jogo da Velha pela CLI.
- **Exibição Gráfica no Console** - Interface simples e limpa para visualização do tabuleiro de jogo.
- **Verificação de Vencedor** - O jogo verifica automaticamente se há um vencedor após cada jogada.
- **Reinício de Jogo** - Permite que os jogadores reiniciem uma nova partida após o término.

## 📓 Documentação
```bash
JogoDaVelha/
├── lib/                      # Bibliotecas externas
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── hackathon/
│   │   │           ├── Main.java               # Classe principal
│   │   │           ├── game/                   # Pacote para lógica do jogo
│   │   │           │   ├── JogoVelha.java      # Classe central do jogo
│   │   │           │   └─ ValidadorDoJogo.java # Classe para validar jogadas
│   │   │           ├── ui/                     # Pacote para interface do usuário
│   │   │           │   ├── MenuDoJogo.java     # Classe para interações no console
│   │   │           │   └── Emojis.java         # Classe para exibir mensagens personalizadas
│   │   │           └── config/                 # Pacote para configuração
│   │   │               └── ConfigDoJogo.java   # Classe para configuração de jogo
├── target/                  # Gerado após build
├── .gitignore               # Arquivos e diretórios ignorados pelo Git
├── pom.xml                  # Arquivo de configuração Maven
├── README.md                # Documentação inicial do projeto
└── LICENSE                  # Licença do projeto
```
