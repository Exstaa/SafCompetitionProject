package az.hafizrzazade.safproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import az.hafizrzazade.safproject.controller.RobotDataController;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	private final RobotDataController robotDataController;

	public WebSocketConfig(RobotDataController robotDataController) {
		this.robotDataController = robotDataController;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(robotDataController, "/send").setAllowedOrigins("*");
	}
}
