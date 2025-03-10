package org.telegram.telegrambots.meta.api.methods.stickers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodBoolean;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

/**
 * @author Ruben Bermudez
 * @version 6.6
 * Use this method to set the thumbnail of a custom emoji sticker set.
 *
 * Returns True on success.
 *
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetCustomEmojiStickerSetThumbnail extends BotApiMethodBoolean {
    public static final String PATH = "setCustomEmojiStickerSetThumbnail";

    public static final String NAME_FIELD = "name";
    public static final String CUSTOM_EMOJI_ID_FIELD = "custom_emoji_id";

    /**
     * Sticker set name
     */
    @NonNull
    @JsonProperty(NAME_FIELD)
    private String name;

    /**
     * Optional.
     *
     * Custom emoji identifier of a sticker from the sticker set;
     * pass an empty string to drop the thumbnail and use the first sticker as the thumbnail.
     */
    @JsonProperty(CUSTOM_EMOJI_ID_FIELD)
    private String customEmojiId;

    @Override
    public String getMethod() {
        return PATH;
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        if (name.isEmpty()) {
            throw new TelegramApiValidationException("name can't be null", this);
        }
    }
}
