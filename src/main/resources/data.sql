-- Insert into moeda table
INSERT INTO moeda (codigo_moeda, nome, simbolo_moeda) VALUES ('220', 'dolar', 'USD');
INSERT INTO moeda (codigo_moeda, nome, simbolo_moeda) VALUES ('978', 'euro', 'EUR');
INSERT INTO moeda (codigo_moeda, nome, simbolo_moeda) VALUES ('000', 'real', 'BRL');

-- Insert into taxa table
INSERT INTO taxa (valor_taxa_venda, valor_taxa_compra, moeda_id) VALUES (5.15, 5.25, (SELECT id FROM moeda WHERE codigo_moeda = '220'));
INSERT INTO taxa (valor_taxa_venda, valor_taxa_compra, moeda_id) VALUES (6.17, 6.22, (SELECT id FROM moeda WHERE codigo_moeda = '978'));
INSERT INTO taxa (valor_taxa_venda, valor_taxa_compra, moeda_id) VALUES (1, 1, (SELECT id FROM moeda WHERE codigo_moeda = '000'));