package com.java.chatGPT;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.java.chatGPT.credenciais.Credenciais;
import okhttp3.*;

public class Pergunta_chatGPT_app extends javax.swing.JFrame {

    /**
     * Creates new form Antenna
     */
    public Pergunta_chatGPT_app() {
        initComponents();
        txt_Pergunta.setText("");
        jTextPane_resposta.setText("");
        jTextField_API_SK.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_Pergunta = new javax.swing.JTextField();
        lbl_ChatGPT = new javax.swing.JLabel();
        btn_Perguntar_gpt3 = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_resposta = new javax.swing.JTextPane();
        btn_Limpar = new javax.swing.JButton();
        btn_Perguntar_gpt4 = new javax.swing.JButton();
        jTextField_API_SK = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pergunte ao ChatGPT");

        txt_Pergunta.setText("jTextField1");

        lbl_ChatGPT.setText("chatGPT");

        btn_Perguntar_gpt3.setText("Perguntar GPT3:");
        btn_Perguntar_gpt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Perguntar_gpt3ActionPerformed(evt);
            }
        });

        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane_resposta);

        btn_Limpar.setText("Limpar");
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });

        btn_Perguntar_gpt4.setText("Perguntar GPT4:");
        btn_Perguntar_gpt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Perguntar_gpt4ActionPerformed(evt);
            }
        });

        jTextField_API_SK.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jTextField_API_SK.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField_API_SK, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sair))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Perguntar_gpt3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Perguntar_gpt4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_ChatGPT)
                            .addComponent(txt_Pergunta, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sair)
                    .addComponent(btn_Limpar)
                    .addComponent(jTextField_API_SK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Perguntar_gpt3)
                    .addComponent(btn_Perguntar_gpt4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Pergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbl_ChatGPT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Perguntar_gpt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Perguntar_gpt3ActionPerformed
        // Pergunta
  
        String MODEL = "gpt-3.5-turbo"; // Alterar para "gpt-3.5-turbo" ou "gpt-4" conforme necessário
        System.out.println("*** Java Netbeans (objeto) " + MODEL + " *** ");
        
        String sk = jTextField_API_SK.getText();

        try {
            // Prompt a ser enviado ao ChatGPT
            String prompt = txt_Pergunta.getText() + "em portugues";

            // Obter resposta do ChatGPT
            String response = getChatGPTResponse(prompt, sk);

            // Extrair o conteúdo da resposta
            String content = extractContentFromResponse(response);

            // Imprimir o conteúdo
            System.out.println("Conteúdo da resposta do ChatGPT: " + content);

            // assim fica tudo numa linha só
           // txt_Resposta.setText(content);

            // para organizar as quebras de linha
            jTextPane_resposta.setText(content);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btn_Perguntar_gpt3ActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed
        // TODO add your handling code here:
        txt_Pergunta.setText("");
        jTextPane_resposta.setText("");
        jTextField_API_SK.setText("");
    }//GEN-LAST:event_btn_LimparActionPerformed

    private void btn_Perguntar_gpt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Perguntar_gpt4ActionPerformed
        // Pergunta
  
        String MODEL = "gpt-4"; // Alterar para "gpt-3.5-turbo" ou "gpt-4" conforme necessário
        System.out.println("*** Java Netbeans (objeto) " + MODEL + " *** ");
        
        String sk = jTextField_API_SK.getText();

        try {
            // Prompt a ser enviado ao ChatGPT
            String prompt = txt_Pergunta.getText() + "em portugues";

            // Obter resposta do ChatGPT
            String response = getChatGPTResponse(prompt, sk);

            // Extrair o conteúdo da resposta
            String content = extractContentFromResponse(response);

            // Imprimir o conteúdo
            System.out.println("Conteúdo da resposta do ChatGPT: " + content);

            // assim fica tudo numa linha só
           // txt_Resposta.setText(content);

            // para organizar as quebras de linha
            jTextPane_resposta.setText(content);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_Perguntar_gpt4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx = 0; idx < installedLookAndFeels.length; idx++) {
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pergunta_chatGPT_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pergunta_chatGPT_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pergunta_chatGPT_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pergunta_chatGPT_app.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pergunta_chatGPT_app().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Limpar;
    private javax.swing.JButton btn_Perguntar_gpt3;
    private javax.swing.JButton btn_Perguntar_gpt4;
    private javax.swing.JButton btn_sair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField jTextField_API_SK;
    private javax.swing.JTextPane jTextPane_resposta;
    private javax.swing.JLabel lbl_ChatGPT;
    private javax.swing.JTextField txt_Pergunta;
    // End of variables declaration//GEN-END:variables

    // Método para enviar uma requisição ao ChatGPT
    public static String getChatGPTResponse(String prompt, String sk) throws IOException {

        String API_URL = new Credenciais().getAPI_URL();
        
         String API_KEY = sk;
        
        // Criar um cliente HTTP
        OkHttpClient client = new OkHttpClient();

        // Criar o payload JSON com o prompt e parâmetros adicionais
        String json = new Gson().toJson(new RequestBodyPayload(prompt, 150));

        // Construir a requisição HTTP usando a sintaxe do OkHttp 4.x
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);

        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .build();

        // Executar a requisição e obter a resposta
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Erro na requisição: " + response);
            }

            // Retornar o corpo da resposta
            return response.body().string();
        }
    }

    // Método para extrair o conteúdo da resposta JSON
    public static String extractContentFromResponse(String jsonResponse) {
        JsonParser parser = new JsonParser(); // Usando o construtor antigo
        JsonElement jsonElement = parser.parse(jsonResponse);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject choiceObject = jsonObject.getAsJsonArray("choices").get(0).getAsJsonObject();
        JsonObject messageObject = choiceObject.getAsJsonObject("message");
        return messageObject.get("content").getAsString();
    }

    // Classe para representar o corpo do payload
    static class RequestBodyPayload {
        
        static final String MODEL = "gpt-3.5-turbo"; // Alterar para "gpt-3.5-turbo" ou "gpt-4" conforme necessário        
    
        String model = MODEL; // Usando a variável MODEL para permitir fácil alteração
        Message[] messages;

        RequestBodyPayload(String prompt, int maxTokens) {
            this.messages = new Message[]{new Message("user", prompt)};
        }

        static class Message {

            String role;
            String content;

            Message(String role, String content) {
                this.role = role;
                this.content = content;
            }
        }
    }

}
