package baseball.util.converter;

import baseball.model.RestartCommand;

public class StringToRestartCommandConverter implements Converter<String, RestartCommand> {

    @Override
    public boolean supports(Object from, Class<?> to) {
        return from.getClass() == String.class && to == RestartCommand.class;
    }

    @Override
    public RestartCommand convert(String source) {
        return RestartCommand.findByInput(source);
    }
}
