INSERT INTO meals (name, description)
    VALUES
        ('Casiotore',    'sauce, cheese, oregano, hunting sausages, pickled cucumbers'),
        ('Bravissimo',   'sauce, cheese, oregano, sausage, mushrooms'),
        ('Perfetto',     'sauce, cheese, oregano, hunting sausages, ham, chicken, tomatoes'),
        ('Belissimo',    'sauce, cheese, oregano, ham, mushrooms, olives, onion'),
        ('Cicilia',      'sauce, cheese, oregano, chicken, mushrooms, tomatoes'),
        ('Four cheeses', 'mozzarella, feta, dor bleu, parmesan, cream sauce'),
        ('Delicia',      'tabasko-sauce, cheese, oregano, minced beef, sausage, pepper, corn'),
        ('Coca-Cola',    'cold drink'),
        ('Morshinska',   'cold drink'),
        ('Green tea',    'hot drink'),
        ('Black tea',    'hot drink'),
        ('Beer',         'do not drink it');

INSERT INTO orders (start_date, start_time, end_date, end_time, status)
    VALUES
        (DATE '2023-08-07', TIME '09:00', DATE '0000-01-01', TIME '00:00', 'ACTIVE'),
        (DATE '2023-08-07', TIME '11:35', DATE '2023-08-07', TIME '12:00', 'DONE'),
        (DATE '2023-08-07', TIME '11:40', DATE '2023-08-07', TIME '11:45', 'CANCELED');
