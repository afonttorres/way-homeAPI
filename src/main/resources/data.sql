INSERT
INTO
  sellers
  (name, username, email, avatar_Url, location)
VALUES
  ('Lola', 'lolafact5', 'lola@gmail.com', 'https://actes.paeria.cat/static/images/unknowCouncilor.png', 'barcelona');
INSERT
INTO
  housings
  (title, description, category, animal, is_Active, img_Url1, img_Url2, img_Url3, location, ratio, publiser_id)
VALUES
  ('Ngerong Apartment', 'New architecture....', 'house', 'dog', TRUE, 'https://images.unsplash.com/photo-1583847268964-b28dc8f51f92?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 'https://images.unsplash.com/photo-1501183638710-841dd1904471?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 'https://images.unsplash.com/photo-1586023492125-27b2c045efd7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=958&q=80', 'barcelona', 4, 1);
INSERT
INTO
  specs
  (spec, housing_id)
VALUES
  ('3 bedrooms', 1);
INSERT
INTO
  specs
  (spec, housing_id)
VALUES
  ('wifi', 1);
INSERT
INTO
  specs
  (spec, housing_id)
VALUES
  ('pool', 1);
INSERT
INTO
  specs
  (spec, housing_id)
VALUES
  ('garden', 1);