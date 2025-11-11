CREATE TABLE category (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NOT NULL,
  `category_alias` VARCHAR(255) NOT NULL,
  `create_user` INT NOT NULL,
  `create_time` DATETIME,
  `update_time` DATETIME,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`category_name` ASC) VISIBLE,
  UNIQUE INDEX `alias_UNIQUE` (`category_alias` ASC) VISIBLE)
COMMENT = '文章分类信息';