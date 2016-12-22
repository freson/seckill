--初始化脚本
--创建数据库
CREATE DATABASE seckill;
--使用数据库
use seckill;
--创建秒杀库存表
CREATE TABLE 'seckill' (
  'seckill_id' bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  'name' varchar(120) NOT NULL COMMENT '商品名称',
  'number' int(11) NOT NULL COMMENT '库存数量',
  'start_time' timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '秒杀开始时间',
  'end_time' timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '秒杀结束时间',
  'create_time' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY ('seckill_id'),
  KEY 'idx_start_time' ('start_time'),
  KEY 'idx_end_time' ('end_time'),
  KEY 'idx_create_time' ('create_time')
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

--初始化数据
insert into seckill(name,number,start_time,end_time)
values
	('1000元秒杀iPhone6',100,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
	('500元秒杀ipad2',100,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
	('300元秒杀小米',100,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
	('200元秒杀充电器',100,'2015-11-01 00:00:00','2015-11-02 00:00:00');
	
--创建秒杀成功明细表
--用户登录认证相关的信息
CREATE TABLE success_seckill(
'seckill_id' bigint NOT NULL  COMMENT '商品库存id',
'user_phone' bigint NOT NULL  COMMENT '手机号',
'state' tinyint NOT NULL DEFAULT -1 COMMENT '状态标识 -1:无效 0:成功 1:已付款',
'create_time' timestamp NOT NULL    COMMENT '创建时间',
PRIMARY KEY (seckill_id,user_phone),
key idx_create_time(create_time)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

--连接mysql
mysql -uroot -p111111

--写此文件是为了记录上线版本
	
	
	

