package com.github.peco2282.priceencyclopedia;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.resources.language.I18n;

public class KeyHandler {
  public static KeyMapping hudKey;

  public static void init() {
    hudKey = new KeyMapping(
        I18n.get("priceencyclopedia.key.keyhandle"),
        'K',
        I18n.get("priceencyclopedia.key.keyhandle.description")
    );
  }
}
