# create database
CREATE DATABASE IF NOT EXISTS app;

# grant privileges
CREATE USER IF NOT EXISTS 'apps'@'%' IDENTIFIED WITH caching_sha2_password BY 'apps';
GRANT ALL PRIVILEGES ON app.* TO 'apps'@'%';
CREATE USER IF NOT EXISTS 'admin'@'%' IDENTIFIED WITH caching_sha2_password BY 'admin';
GRANT ALL PRIVILEGES ON *.* TO 'admin'@'%' WITH GRANT OPTION;
CREATE USER IF NOT EXISTS 'replicator'@'%' IDENTIFIED WITH caching_sha2_password BY 'PaSSw0Rd';
GRANT REPLICATION SLAVE , REPLICATION CLIENT ON *.* TO 'replicator'@'%';
FLUSH PRIVILEGES;

# create database and user
CREATE DATABASE IF NOT EXISTS log;
CREATE USER IF NOT EXISTS 'logs'@'%' IDENTIFIED WITH caching_sha2_password BY 'logs';
GRANT ALL PRIVILEGES ON log.* TO 'logs'@'%';

# create log table
USE log;

BEGIN;
DROP TABLE IF EXISTS application_log;
COMMIT;

BEGIN;
CREATE TABLE application_log
(
    log_id          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    timestamp       DATETIME     NOT NULL,
    level           VARCHAR(254) NOT NULL,
    logger          VARCHAR(254) NOT NULL,
    marker          VARCHAR(254),
    message         TEXT,
    location        TEXT,
    caller_filename VARCHAR(254),
    caller_class    VARCHAR(254),
    caller_method   VARCHAR(254),
    caller_line     CHAR(4),
    process_id      INT          NOT NULL,
    thread_id       INT          NOT NULL,
    thread_name     VARCHAR(254) NOT NULL,
    thread_priority INT          NOT NULL,
    exception       TEXT
);
COMMIT;
