package org.telegram.telegrambots.meta.api.methods.forum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;
import lombok.extern.jackson.Jacksonized;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethodBoolean;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;
import org.telegram.telegrambots.meta.util.Validations;

/**
 * @author Ruben Bermudez
 * @version 6.4
 * Use this method to edit the name of the 'General' topic in a forum supergroup chat.
 * The bot must be an administrator in the chat for this to work and must have can_manage_topics administrator rights.
 *
 * Returns True on success.
 */
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SuperBuilder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditGeneralForumTopic extends BotApiMethodBoolean {
    public static final String PATH = "editGeneralForumTopic";

    private static final String CHATID_FIELD = "chat_id";
    private static final String NAME_FIELD = "name";

    /**
     * Unique identifier for the target chat or username
     * of the target supergroup (in the format @supergroupusername)
     */
    @JsonProperty(CHATID_FIELD)
    @NonNull
    private String chatId;
    /**
     * Optional.
     * New topic name, 1-128 characters
     */
    @JsonProperty(NAME_FIELD)
    @NonNull
    private String name;

    @Tolerate
    public void setChatId(@NonNull Long chatId) {
        this.chatId = chatId.toString();
    }

    @Override
    public void validate() throws TelegramApiValidationException {
        Validations.requiredChatId(chatId, this);
        if (name.isEmpty() || name.length() > 128) {
            throw new TelegramApiValidationException("Name must be between 1 and 128 characters", this);
        }
    }

    @Override
    public String getMethod() {
        return PATH;
    }

    public static abstract class EditGeneralForumTopicBuilder<C extends EditGeneralForumTopic, B extends EditGeneralForumTopicBuilder<C, B>> extends BotApiMethodBooleanBuilder<C, B> {
        @Tolerate
        public EditGeneralForumTopicBuilder<C, B> chatId(@NonNull Long chatId) {
            this.chatId = chatId.toString();
            return this;
        }
    }
}
