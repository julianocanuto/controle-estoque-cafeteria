INSERT INTO tb_produto (nome, preco, img_uri) VALUES ('Cookie de chocolate', 3.45, 'https://cooknenjoy.com/wp-content/uploads/2016/12/cookies-01-1200x675.jpg');
INSERT INTO tb_produto (nome, preco, img_uri) VALUES ('Cookie de baunilha', 3.45, 'https://harald.com.br/wp-content/uploads/2020/08/Cookie_720x500.jpg');

INSERT INTO tb_ingrediente (nome, unidade_de_medida, preco_unitario) VALUES ('farinha', 'g', 12);
INSERT INTO tb_ingrediente (nome, unidade_de_medida, preco_unitario) VALUES ('leite', 'ml', 7);
INSERT INTO tb_ingrediente (nome, unidade_de_medida, preco_unitario) VALUES ('ovo', 'g', 5);
INSERT INTO tb_ingrediente (nome, unidade_de_medida, preco_unitario) VALUES ('chocolate em pó', 'g', 15);
INSERT INTO tb_ingrediente (nome, unidade_de_medida, preco_unitario) VALUES ('essencia de baunilha', 'ml', 6);

INSERT INTO tb_componente (produto_id, ingrediente_id, quantidade) VALUES (1, 1, 200);
INSERT INTO tb_componente (produto_id, ingrediente_id, quantidade) VALUES (1, 2, 150);
INSERT INTO tb_componente (produto_id, ingrediente_id, quantidade) VALUES (1, 3, 66);
INSERT INTO tb_componente (produto_id, ingrediente_id, quantidade) VALUES (1, 4, 70);

INSERT INTO tb_componente (produto_id, ingrediente_id, quantidade) VALUES (2, 1, 200);
INSERT INTO tb_componente (produto_id, ingrediente_id, quantidade) VALUES (2, 2, 150);
INSERT INTO tb_componente (produto_id, ingrediente_id, quantidade) VALUES (2, 3, 66);
INSERT INTO tb_componente (produto_id, ingrediente_id, quantidade) VALUES (2, 5, 5);

INSERT INTO tb_user (name, email, password) VALUES ('Dono da cafeteria', 'dono@cafeteria.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Operador 01', 'operador01@cafeteria.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Operador 02', 'operador02@cafeteria.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);

INSERT INTO tb_estoque (id, estocavel_id, estocavel_tipo, estocavel_unidade_de_medida, operacao_no_estoque, quantidade) values (1, 1, 'produto', 'unidade', 'entrada', 5);
INSERT INTO tb_estoque (id, estocavel_id, estocavel_tipo, estocavel_unidade_de_medida, operacao_no_estoque, quantidade) values (2, 2, 'produto', 'unidade', 'entrada', 3);
INSERT INTO tb_estoque (id, estocavel_id, estocavel_tipo, estocavel_unidade_de_medida, operacao_no_estoque, quantidade) values (3, 3, 'produto', 'unidade', 'entrada', 2);
INSERT INTO tb_estoque (id, estocavel_id, estocavel_tipo, estocavel_unidade_de_medida, operacao_no_estoque, quantidade) values (4, 1, 'ingrediente', 'unidade', 'entrada', 5000);
INSERT INTO tb_estoque (id, estocavel_id, estocavel_tipo, estocavel_unidade_de_medida, operacao_no_estoque, quantidade) values (5, 1, 'ingrediente', 'unidade', 'saida', 2000);
