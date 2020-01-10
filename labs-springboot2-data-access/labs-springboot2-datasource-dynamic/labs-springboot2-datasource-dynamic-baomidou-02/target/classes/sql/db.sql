CREATE TABLE `dynamic_datasource_orders` (
  `id` int(11) DEFAULT NULL COMMENT '订单编号',
  `user_id` int(16) DEFAULT NULL COMMENT '用户编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='订单表';
