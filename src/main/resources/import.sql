INSERT INTO tb_produto (nome, preco, img_uri) VALUES ('Cookie de chocolate', 3.45, 'https://cooknenjoy.com/wp-content/uploads/2016/12/cookies-01-1200x675.jpg');
INSERT INTO tb_produto (nome, preco, img_uri) VALUES ('Cookie de baunilha', 3.45, 'https://harald.com.br/wp-content/uploads/2020/08/Cookie_720x500.jpg');

INSERT INTO tb_ingrediente (nome, unidade_de_medida, preco_unitario) VALUES ('farinha', 'g', 12);
INSERT INTO tb_ingrediente (nome, unidade_de_medida, preco_unitario) VALUES ('leite', 'ml', 7);
INSERT INTO tb_ingrediente (nome, unidade_de_medida, preco_unitario) VALUES ('ovo', 'g', 5);
INSERT INTO tb_ingrediente (nome, unidade_de_medida, preco_unitario) VALUES ('chocolate em pó', 'g', 15);
INSERT INTO tb_ingrediente (nome, unidade_de_medida, preco_unitario) VALUES ('essencia de baunilha', 'ml', 6);

INSERT INTO tb_componente (produto_id, ingrediente_id) VALUES (1, 1);
INSERT INTO tb_componente (produto_id, ingrediente_id) VALUES (1, 2);
INSERT INTO tb_componente (produto_id, ingrediente_id) VALUES (1, 3);
INSERT INTO tb_componente (produto_id, ingrediente_id) VALUES (1, 4);

INSERT INTO tb_componente (produto_id, ingrediente_id) VALUES (2, 1);
INSERT INTO tb_componente (produto_id, ingrediente_id) VALUES (2, 2);
INSERT INTO tb_componente (produto_id, ingrediente_id) VALUES (2, 3);
INSERT INTO tb_componente (produto_id, ingrediente_id) VALUES (2, 5);