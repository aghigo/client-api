
# client-api

# Premissas

- Serão avaliadas todas as características da solução apresentada
- Caso não saiba por onde começar, procure algum tutorial de criação de CRUD Rest com Spring Boot
- Caso tenha dificuldades ou não saiba como continuar, entregue até onde conseguir e explique quais problemas teve
- Usamos Java em nossos sitemas
- Considere apenas a parte backend. Não é necessário desenvolver tela/formulário, apenas os endpoints REsT
- Um cliente é composto apenas por nome e idade
- API aberta de geolocalização por IP https://www.ipvigilante.com/
- API aberta de clima por geolocalização https://metaweather.com/api/
- Quando executar a busca de clima por geolocalização, caso não exista a cidade especifica de origem, utilize o resultado mais próximo.

# Sua tarefa é desenvolver os serviços REST abaixo:
- Criar um Cliente
- Alterar um Cliente
- Consultar um Cliente por id
- Listar todos os Clientes salvos
- Remover Cliente por id
- Entregar o projeto via GitHub

Ao criar um cliente, apenas para fins estatísticos e históricos, busque qual a localização geográfica de quem executou a requisição, usando o IP de origem. Com a localização geográfica, consulte qual é a temperatura máxima e mínima do dia da requisição de criação no local do IP de origem. Salve essa informação e a associe ao cliente resultado da requisição de origem.

Tenha em mente que a consulta do Cliente por ID será altamente requisitada.

Junto com o código é necessário entregar uma documentação que contenha os itens abaixo:
- Como usar os serviços
- Quais ferramentas foram usadas (e por que foram as escolhidas)
- Qualquer infraestrutura adicional necessária para executar, testar, empacotar e entregar seu projeto
- Como executar, testar, empacotar e entregar o seu projeto
- Instruções para como montar o ambiente de produção onde seus serviços devem ser executados (preferencialmente citando ferramentas e processos)
