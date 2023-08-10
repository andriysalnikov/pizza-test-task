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
        (DATE '2023-08-07', TIME '09:00', NULL, NULL, 'ACTIVE'),
        (DATE '2023-08-07', TIME '11:35', DATE '2023-08-07', TIME '12:00', 'DONE'),
        (DATE '2023-08-07', TIME '11:40', DATE '2023-08-07', TIME '12:00', 'NONE'),
        (DATE '2023-08-07', TIME '11:40', DATE '2023-08-07', TIME '11:45', 'CANCELED');

INSERT INTO orders_meals (order_id, meal_id)
    VALUES
        (1, 1), (1, 4), (1, 8), (1, 8),
        (2, 6), (2, 7), (2, 8), (2, 9), (2, 2),
        (3, 5), (3, 5), (3, 2), (3, 9), (3, 9), (3, 11), (3, 11), (3, 11);