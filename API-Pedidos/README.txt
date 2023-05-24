Nesse arquivo README explica-se como verificar as regras de negocio do exercício
Regra de negocio:  Todos os serviços devem trabalhar com XML e JSON para chamadas e retornos. Para verificar a implementação de esta regra de negocio se crio para cada request em formato Json sua equivalente em formato XML.

Regra de negócio: Criar um serviço que receba pedidos com 6 campos:
número controle - número aleatório informado pelo cliente, data cadastro (opcional)
nome - nome do produto, valor - valor monetário unitário produto, quantidade (opcional) - quantidade de produtos,  código cliente - identificação numérica do cliente. Para verificar a implementação desta regra primeiro criamos alguns parâmetros que utilizaremos como os clientes, items, e depois criamos 1 arquivo que contem 1 pedido com 2 items.
Executamos no postman
1-Teste criação clientes
2-Teste criação items
3-Teste criação arquivo

Regra de negocio:   O arquivo pode conter 1 ou mais pedidos, limitado a 10. Esta regra de negócio foi verificada no teste unitário:  teste_arquivo_com_mais_de_10_pedidos_exception

Regra de negocio:  Não poderá aceitar um número de controle já cadastrado. Verificação: Caso tentar cadastrar dois pedidos, clientes ou items com o mesmo id-código o sistema retorna um status 409 que representa um conflito por recursos duplicados.

Regra de negócio: Caso a data de cadastro não seja enviada o sistema deve assumir a data atual. Esta regra de negocio foi verificada no teste unitário:
teste_sem_data_de_cadastro

Regra de negócio:   Caso a quantidade não seja enviada considerar 1. Esta regra de negocio foi verificada no teste unitário:
teste_quantidade_igual_a_cero

Regra de negocio:  Caso a quantidade seja maior que 5 aplicar 5% de desconto no valor total, para quantidades a partir de 10 aplicar 10% de desconto no valor total. Esta regra de negocio foi verificada nos testes unitarios:
teste_calcula_valor_com_5_por_cento_desconto
teste_calcula_valor_com_10_por_cento_desconto

Regra de negocio:  O sistema deve calcular e gravar o valor total do pedido. Esta regra de negocio foi verificada no teste unitário:
teste_calcula_valor_total_sem_desconto

Regra de negocio: Criar um serviço onde possa consultar os pedidos enviados pelos clientes. 
Critérios aceitação: O retorno deve trazer todos os dados do pedido, filtros da consulta: 
número pedido, data cadastro, cliente, todos.  Para verificar esta regra de negocio, executamos as request que estão dentro da pasta 5-Teste consultas no postman
Buscar pedido por cliente
Buscar todos os pedidos do cliente
Buscar todos os pedidos por data
Buscar todos os pedidos

Regra de negocio:  Ao subir a aplicação, o banco de dados deve conter 10 pedidos cadastrados, um para cada cliente cadastrado, com códigos de cliente de 1 a 10. Esta configuração foi feita na aplicação, apenas é necessário criar o banco de dados com o nome “pedidos” e um usuario: “marcos” com a senha “marcos123” no MySQL. A aplicação cada vêz que sobe, cria todas as tabelas automaticamente, e insere os dados de exemplo nas tabelas.
