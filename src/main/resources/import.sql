INSERT INTO tb_post(title, content, category, created_At, updated_At) VALUES ('My First Blog Post', 'This is the content of my first blog post.', 'Technology', NOW(), NOW())
INSERT INTO tb_post(title, content, category, created_At, updated_At) VALUES ('My Second Blog Post', 'This is the content of my second blog post.', 'Technology', NOW(), NOW())

INSERT INTO tb_post_tags(post_id, tag_name) VALUES (1, 'Tech')
INSERT INTO tb_post_tags(post_id, tag_name) VALUES (1, 'Programming')
INSERT INTO tb_post_tags(post_id, tag_name) VALUES (2, 'Tech')
INSERT INTO tb_post_tags(post_id, tag_name) VALUES (2, 'Programming')