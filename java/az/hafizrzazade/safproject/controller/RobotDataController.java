package az.hafizrzazade.safproject.controller;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import az.hafizrzazade.safproject.model.RobotData;
import az.hafizrzazade.safproject.repository.RobotDataRepository;

@Component
public class RobotDataController extends TextWebSocketHandler {

	@Autowired
	private RobotDataRepository repo;
	private final ObjectMapper mapper = new ObjectMapper();
	private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

	public RobotDataController(RobotDataRepository repo) {
		this.repo = repo;
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
		System.out.println("Client connected: " + session.getId());
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		RobotData data = mapper.readValue(message.getPayload(), RobotData.class);

		data.setId(0);
		repo.save(data);

		String json = mapper.writeValueAsString(data);
		for (WebSocketSession s : sessions) {
			if (s.isOpen()) {
				s.sendMessage(new TextMessage(json));
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
		System.out.println("Client disconnected: " + session.getId());
	}

}
