package com.zsinda.fdp.dto;

import lombok.Data;

import java.util.List;

/**
 * @program: FDPlatform
 * @description: TreeNode
 * @author: Sinda
 * @create: 2020-01-02 23:38
 */
@Data
public class TreeNode {

    protected int id;

    protected int parentId;

    protected int value;

    protected List<TreeNode> children=null;

    public void add(TreeNode node) {
        children.add(node);
    }
}
