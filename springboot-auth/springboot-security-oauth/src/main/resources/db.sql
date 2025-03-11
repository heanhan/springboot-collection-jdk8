-- 用户表
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

-- 角色表
CREATE TABLE roles (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL UNIQUE
);

-- 权限表
CREATE TABLE permissions (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(255) NOT NULL UNIQUE
);

-- 用户 - 角色关联表
CREATE TABLE user_roles (
                            user_id BIGINT,
                            role_id BIGINT,
                            PRIMARY KEY (user_id, role_id),
                            FOREIGN KEY (user_id) REFERENCES users(id),
                            FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- 角色 - 权限关联表
CREATE TABLE role_permissions (
                                  role_id BIGINT,
                                  permission_id BIGINT,
                                  PRIMARY KEY (role_id, permission_id),
                                  FOREIGN KEY (role_id) REFERENCES roles(id),
                                  FOREIGN KEY (permission_id) REFERENCES permissions(id)
);

-- OAuth2 客户端表
CREATE TABLE oauth_client_details (
                                      client_id VARCHAR(255) PRIMARY KEY,
                                      resource_ids VARCHAR(255),
                                      client_secret VARCHAR(255),
                                      scope VARCHAR(255),
                                      authorized_grant_types VARCHAR(255),
                                      web_server_redirect_uri VARCHAR(255),
                                      authorities VARCHAR(255),
                                      access_token_validity INTEGER,
                                      refresh_token_validity INTEGER,
                                      additional_information VARCHAR(4096),
                                      autoapprove VARCHAR(255)
);