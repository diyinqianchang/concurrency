package com.abc.run;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2025/4/20 10:32
 * @Version 1.0
 */
public class SubList {

    public static <T> List<List<T>> groupList(List<T> originalList, int groupSize) {
        List<List<T>> groupedLists = new ArrayList<>();
        int totalSize = originalList.size();

        for (int i = 0; i < totalSize; i += groupSize) {
            // 计算当前组的结束索引，注意不能超过列表大小
            int end = Math.min(i + groupSize, totalSize);
            // 创建子列表并添加到结果列表中
            groupedLists.add(new ArrayList<>(originalList.subList(i, end)));
        }

        return groupedLists;
    }

    public static void main(String[] args) {


        // 创建一个示例列表，包含1020个元素
        List<Integer> originalList = new ArrayList<>();
        for (int i = 1; i <= 1020; i++) {
            originalList.add(i);
        }

        // 将列表分组，每组100个元素
        int groupSize = 100;
        List<List<Integer>> groupedLists = groupList(originalList, groupSize);

        // 输出分组结果
        for (int i = 0; i < groupedLists.size(); i++) {
            System.out.println("Group " + (i + 1) + ": " + groupedLists.get(i));
        }

    }


}
