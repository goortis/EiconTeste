INSERT INTO cliente (id, nome) VALUES (1, 'Cliente1');
INSERT INTO cliente (id, nome) VALUES (2, 'Cliente2');
INSERT INTO cliente (id, nome) VALUES (3, 'Cliente3');
INSERT INTO cliente (id, nome) VALUES (4, 'Cliente4');
INSERT INTO cliente (id, nome) VALUES (5, 'Cliente5');
INSERT INTO cliente (id, nome) VALUES (6, 'Cliente6');
INSERT INTO cliente (id, nome) VALUES (7, 'Cliente7');
INSERT INTO cliente (id, nome) VALUES (8, 'Cliente8');
INSERT INTO cliente (id, nome) VALUES (9, 'Cliente9');
INSERT INTO cliente (id, nome) VALUES (10, 'Cliente10');
INSERT INTO cliente (id, nome) VALUES (11, 'Cliente11');
INSERT INTO cliente (id, nome) VALUES (12, 'Cliente12');

INSERT INTO item  (id,nome) values (1,'Item 1');
INSERT INTO item  (id,nome) values (2,'Item 2');
INSERT INTO item  (id,nome) values (3,'Item 3');
INSERT INTO item  (id,nome) values (4,'Item 4');
INSERT INTO item  (id,nome) values (5,'Item 5');
INSERT INTO item  (id,nome) values (6,'Item 6');
INSERT INTO item  (id,nome) values (7,'Item 7');
INSERT INTO item  (id,nome) values (8,'Item 8');
INSERT INTO item  (id,nome) values (9,'Item 9');
INSERT INTO item  (id,nome) values (10,'Item 10');

INSERT INTO arquivo (id, nome) VALUES (1,"Arquivo001");

INSERT INTO pedido (cod_pedido,data_cadastro, nome,total,cliente_id,codigo_arquivo) values (1,STR_TO_DATE('2023-05-23','%Y-%m-%d'),'Pedido 1', 200,1,1);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (1,1,100,1,1);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (2,2,50,2,1); 

INSERT INTO pedido (cod_pedido,data_cadastro, nome,total,cliente_id,codigo_arquivo) values (2,STR_TO_DATE('2023-05-23','%Y-%m-%d'),'Pedido 2', 150,2,1);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (3,3,10,3,2);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (4,4,30,4,2);

INSERT INTO pedido (cod_pedido,data_cadastro, nome,total,cliente_id,codigo_arquivo) values (3,STR_TO_DATE('2023-05-23','%Y-%m-%d'),'Pedido 3', 221,3,1);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (5,5,10,5,3); 
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (6,6,30,6,3); 

INSERT INTO pedido (cod_pedido,data_cadastro, nome,total,cliente_id,codigo_arquivo) values (4,STR_TO_DATE('2023-05-23','%Y-%m-%d'),'Pedido 4', 294.50,4,1);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (7,7,10,5,4); 
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (8,8,30,6,4); 

INSERT INTO pedido (cod_pedido,data_cadastro, nome,total,cliente_id,codigo_arquivo) values (5,STR_TO_DATE('2023-05-23','%Y-%m-%d'),'Pedido 5', 355.50,5,1);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (9,9,10,5,5); 
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (10,10,30,6,5); 

INSERT INTO pedido (cod_pedido,data_cadastro, nome,total,cliente_id,codigo_arquivo) values (6,STR_TO_DATE('2023-05-23','%Y-%m-%d'),'Pedido 6', 381,6,1);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (11,6,10,5,6); 
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (12,12,30,6,6); 

INSERT INTO pedido (cod_pedido,data_cadastro, nome,total,cliente_id,codigo_arquivo) values (7,STR_TO_DATE('2023-05-23','%Y-%m-%d'),'Pedido 7', 423,7,1);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (13,11,10,5,7); 
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (14,12,30,6,7); 

INSERT INTO pedido (cod_pedido,data_cadastro, nome,total,cliente_id,codigo_arquivo) values (8,STR_TO_DATE('2023-05-23','%Y-%m-%d'),'Pedido 8', 80,8,1);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (15,2,10,5,8);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (16,3,20,6,8);

INSERT INTO pedido (cod_pedido,data_cadastro, nome,total,cliente_id,codigo_arquivo) values (9,STR_TO_DATE('2023-05-23','%Y-%m-%d'),'Pedido 9', 190,9,1);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (17,4,10,5,9);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (18,5,30,6,9);

INSERT INTO pedido (cod_pedido,data_cadastro,  nome,total,cliente_id,codigo_arquivo) values (10,STR_TO_DATE('2023-05-23','%Y-%m-%d'),'Pedido 10', 256.50,10,1);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (19,6,10,5,10);
INSERT INTO item_pedido (id, quantidade,valor,codigo_item,codigo_pedido) values (20,7,30,6,10); 