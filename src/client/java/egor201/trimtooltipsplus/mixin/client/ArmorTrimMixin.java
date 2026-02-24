package egor201.trimtooltipsplus.mixin.client;

import net.minecraft.item.Item;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ArmorTrim.class)
public class ArmorTrimMixin {

    @Inject(at = @At("HEAD"), method = "appendTooltip", cancellable = true)
    public void onAppendTooltip(Item.TooltipContext context, Consumer<Text> tooltip, TooltipType type, CallbackInfo ci) {
        ci.cancel();

        ArmorTrim self = (ArmorTrim) (Object) this;
        
        Text patternText = self.getPattern().value().description();
        Text materialText = self.getMaterial().value().description();
        
        Style materialStyle = materialText.getStyle();

        Text result = Text.empty()
                .append(patternText.copy().formatted(Formatting.GRAY))
                .append(ScreenTexts.SPACE)
                .append(Text.literal("(").setStyle(materialStyle))
                .append(materialText.copy().setStyle(materialStyle))
                .append(Text.literal(")").setStyle(materialStyle));

        tooltip.accept(result);
    }
}
