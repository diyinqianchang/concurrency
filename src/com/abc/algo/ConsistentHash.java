package com.abc.algo;

import java.util.*;

/**
 * @Author Administrator
 * @Date 2025/12/3 22:00
 * @Version 1.0
 */
public class ConsistentHash {

    // 虚拟节点数量（解决数据倾斜问题）
    private final int virtualNodeCount;
    // 哈希环，使用TreeMap实现有序的环结构
    private final TreeMap<Integer, String> hashCircle;
    // 哈希函数
    private final HashFunction hashFunction;

    public ConsistentHash(int virtualNodeCount, List<String> nodes) {
        this.virtualNodeCount = virtualNodeCount;
        this.hashCircle = new TreeMap<>();
        this.hashFunction = new MD5Hash(); // 可以使用其他哈希算法

        // 初始化哈希环
        for (String node : nodes) {
            addNode(node);
        }
    }

    // 哈希函数接口
    interface HashFunction {
        int hash(String key);
    }

    // MD5哈希实现（简化版）
    static class MD5Hash implements HashFunction {
        @Override
        public int hash(String key) {
            // 实际应用中应该使用更完整的MD5或SHA-1实现
            return key.hashCode() & Integer.MAX_VALUE; // 确保非负
        }
    }

    // 添加节点
    public void addNode(String node) {
        for (int i = 0; i < virtualNodeCount; i++) {
            // 为每个物理节点创建多个虚拟节点
            String virtualNode = node + "#" + i;
            int hash = hashFunction.hash(virtualNode);
            hashCircle.put(hash, node);
        }
    }

    // 移除节点
    public void removeNode(String node) {
        for (int i = 0; i < virtualNodeCount; i++) {
            String virtualNode = node + "#" + i;
            int hash = hashFunction.hash(virtualNode);
            hashCircle.remove(hash);
        }
    }

    // 获取数据应该存储的节点
    public String getNode(String key) {
        if (hashCircle.isEmpty()) {
            return null;
        }

        int hash = hashFunction.hash(key);

        // 查找环上大于等于该哈希值的第一个节点
        Map.Entry<Integer, String> entry = hashCircle.ceilingEntry(hash);

        // 如果没找到（说明在环的末尾），则返回环的第一个节点
        if (entry == null) {
            entry = hashCircle.firstEntry();
        }

        return entry.getValue();
    }

    // 数据分布统计
    public Map<String, Integer> getDistributionStats(List<String> keys) {
        Map<String, Integer> stats = new HashMap<>();

        for (String key : keys) {
            String node = getNode(key);
            stats.put(node, stats.getOrDefault(node, 0) + 1);
        }

        return stats;
    }

    // 测试代码
    public static void main(String[] args) {
        // 初始化节点
        List<String> nodes = Arrays.asList(
                "Node-A", "Node-B", "Node-C", "Node-D"
        );

        // 创建一致性哈希环，每个物理节点有100个虚拟节点
        ConsistentHash consistentHash = new ConsistentHash(100, nodes);

        // 测试数据
        List<String> testKeys = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            testKeys.add("key-" + i);
        }

        // 获取数据分布
        Map<String, Integer> distribution = consistentHash.getDistributionStats(testKeys);
        System.out.println("初始数据分布:");
        distribution.forEach((node, count) -> {
            double percentage = (count * 100.0) / testKeys.size();
            System.out.printf("%s: %d (%.2f%%)\n", node, count, percentage);
        });

        // 添加新节点
        System.out.println("\n添加新节点 Node-E 后的数据分布:");
        consistentHash.addNode("Node-E");
        distribution = consistentHash.getDistributionStats(testKeys);
        distribution.forEach((node, count) -> {
            double percentage = (count * 100.0) / testKeys.size();
            System.out.printf("%s: %d (%.2f%%)\n", node, count, percentage);
        });

        // 移除节点
        System.out.println("\n移除节点 Node-B 后的数据分布:");
        consistentHash.removeNode("Node-B");
        distribution = consistentHash.getDistributionStats(testKeys);
        distribution.forEach((node, count) -> {
            double percentage = (count * 100.0) / testKeys.size();
            System.out.printf("%s: %d (%.2f%%)\n", node, count, percentage);
        });
    }


}
