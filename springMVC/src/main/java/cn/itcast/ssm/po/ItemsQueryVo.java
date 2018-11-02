package cn.itcast.ssm.po;

import java.util.List;

public class ItemsQueryVo {

//    商品信息
    private Items items;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    //    为了系统的可扩展性，对原始生成的po   items类进行扩展
    private ItemsCustom itemsCustom;

    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    //批量商品删除list 存的的是id
    private List<Integer> items_id;

    public List<Integer> getItems_id() {
        return items_id;
    }
    public void setItems_id(List<Integer> items_id) {
        this.items_id = items_id;
    }

//批量修改list 存入的是商品
    private List<ItemsCustom> itemsList;

    public List<ItemsCustom> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsCustom> itemsList) {
        this.itemsList = itemsList;
    }
}