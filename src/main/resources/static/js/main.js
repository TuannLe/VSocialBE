let stompClient = null;
let userId = 1;  // Giả sử đây là ID người dùng đang đăng nhập
let receiverId = 2;  // ID người dùng bạn muốn gửi tin nhắn

function connect() {
    let socket = new SockJS('/ws');  // Kết nối tới WebSocket server
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);

        // Đăng ký nhận tin nhắn từ người nhận
        stompClient.subscribe('/queue/messages/' + userId, function (message) {
            showMessage(JSON.parse(message.body));  // Xử lý và hiển thị tin nhắn
        });
    });
}

function sendMessage() {
    let messageInput = document.getElementById('messageInput').value;

    // Tạo đối tượng tin nhắn
    let chatMessage = {
        content: messageInput,
        senderId: userId,
        receiverId: receiverId
    };

    // Gửi tin nhắn đến server WebSocket
    stompClient.send("/app/chat.send", {}, JSON.stringify(chatMessage));

    // Clear input sau khi gửi
    document.getElementById('messageInput').value = '';
}

function showMessage(message) {
    let messageArea = document.getElementById('messageArea');
    let messageElement = document.createElement('div');

    // Hiển thị tin nhắn
    messageElement.appendChild(document.createTextNode(message.content));
    messageArea.appendChild(messageElement);
}

// Kết nối WebSocket khi trang được tải
window.onload = connect;
