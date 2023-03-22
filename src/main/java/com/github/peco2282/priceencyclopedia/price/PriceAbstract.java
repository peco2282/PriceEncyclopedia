package com.github.peco2282.priceencyclopedia.price;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SuppressWarnings("unused")
public class PriceAbstract {

  private String itemName;
  private ItemType type;
  private int price;
  private PaymentType paymentType;
  private ReceiptType receiptType;

  public PriceAbstract(String itemName, ItemType type, int price, PaymentType paymentType, ReceiptType receiptType) {
    this.itemName = itemName;
    this.type = type;
    this.price = price;
    this.paymentType = paymentType;
    this.receiptType = receiptType;
  }

  private PriceAbstract() {
  }

  public static PriceAbstract parsePriceAbstract(Map<String, String> map) {
    PriceAbstract pa = new PriceAbstract();
    try {
      pa.setItemName(map.get("name"));
      pa.setType(pa.getItemTypeFromString(map.get("type")));
      pa.setPrice(Integer.parseInt(map.get("price")));
      pa.setPaymentType(pa.getPaymentTypeFromString(map.get("payment")));
      pa.setReceiptType(pa.getReceiptTypeFromString(map.get("receipt")));
    } catch (Exception igore) {
      pa.setItemName("");
      pa.setType(ItemType.INVALID);
      pa.setPrice(0);
      pa.setPaymentType(PaymentType.INVALID);
      pa.setReceiptType(ReceiptType.INVALID);
    }
    return pa;
  }

  public @NotNull Map<String, String> toMap() {
    Map<String, String> map = new HashMap<>();
    map.put("name", this.itemName);
    map.put("type", this.getItemTypeToString());
    map.put("price", String.valueOf(this.price));
    map.put("payment", this.getPaymentTypeToString());
    map.put("receipt", this.getReceiptTypeToString());
    return map;
  }

  public String getItemName() {
    return itemName;
  }

  private void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public ItemType getType() {
    return type;
  }

  private void setType(ItemType type) {
    this.type = type;
  }

  public int getPrice() {
    return price;
  }

  private void setPrice(int price) {
    this.price = price;
  }

  public PaymentType getPaymentType() {
    return paymentType;
  }

  private void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  public ReceiptType getReceiptType() {
    return receiptType;
  }

  private void setReceiptType(ReceiptType receiptType) {
    this.receiptType = receiptType;
  }

  public String getItemTypeToString() {
    return switch (type) {
      case BLOCK -> "block";
      case ITEM -> "item";
      default -> null;
    };
  }

  public ItemType getItemTypeFromString(String type) {
    return switch (type) {
      case "block" -> ItemType.BLOCK;
      case "item" -> ItemType.ITEM;
      default -> ItemType.INVALID;
    };
  }

  public String getPaymentTypeToString() {
    return switch (paymentType) {
      case G -> "g";
      case D -> "d";
      case DB -> "db";
      case STD -> "std";
      case STDB -> "stdb";
      case INVALID -> null;
    };
  }

  public PaymentType getPaymentTypeFromString(String type) {
    return switch (type) {
      case "g" -> PaymentType.G;
      case "d" -> PaymentType.D;
      case "db" -> PaymentType.DB;
      case "std" -> PaymentType.STD;
      case "stdb" -> PaymentType.STDB;
      default -> PaymentType.INVALID;
    };
  }

  public String getReceiptTypeToString() {
    return switch (receiptType) {
      case ONE -> "one"; // fixme confファイルに追加のこと
      case ST -> "st";
      case C -> "c";
      case LC -> "lc";
      case INVALID -> null;
    };
  }

  public ReceiptType getReceiptTypeFromString(String type) {
    return switch (type.toLowerCase()) {
      case "one" -> ReceiptType.ONE;
      case "st" -> ReceiptType.ST;
      case "c" -> ReceiptType.C;
      case "lc" -> ReceiptType.LC;
      default -> ReceiptType.INVALID;
    };
  }

  public enum ItemType {
    BLOCK,
    ITEM,
    INVALID
  }

  public enum PaymentType {
    G,
    D,
    DB,
    STD,
    STDB,
    INVALID
  }

  public enum ReceiptType {
    ONE,
    ST,
    C,
    LC,
    INVALID
  }
}
