package com.github.peco2282.priceencyclopedia.key;

import com.github.peco2282.priceencyclopedia.PriceEncyclopedia;
import com.github.peco2282.priceencyclopedia.screen.StateScreen;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeyInputEvent {
	PoseStack stack;

	@SubscribeEvent
	public void o(RenderGuiOverlayEvent.Post event) {
		stack = event.getPoseStack();
	}

	@SubscribeEvent
	public void onKeyPressed(final InputEvent.Key key) {
		if (KeyHandler.getKeyMapping().consumeClick()) {
			if (key.getModifiers() == 0) {
				PriceEncyclopedia.getLOGGER().info("modifires");
				PriceEncyclopedia.changeState();
				StateScreen.renderScreen(stack);
			}
		}
	}

}
