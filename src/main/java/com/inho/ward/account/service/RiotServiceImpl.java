package com.inho.ward.account.service;

import com.inho.ward.account.dto.AccountDTO;
import com.inho.ward.account.dto.GetPuuidDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class RiotServiceImpl implements RiotService {
    private final Environment environment;
    private OutputStreamWriter writer;
    private BufferedReader br;
    @Override
    public AccountDTO getPuuid(GetPuuidDTO getPuuidDTO) throws IOException {
        try {
            final String RIOT_API_KEY = environment.getProperty("RIOT_API_KEY");
            log.info("RIOT_API_KEY: " + RIOT_API_KEY);
            String utfGameName = encodingUTF(getPuuidDTO.getGameName());
            String utfTagLine = encodingUTF(getPuuidDTO.getTagLine());

            URL url = new URL(environment.getProperty("RIOT_API_URL") + "/by-riot-id/" + utfGameName + "/" + utfTagLine + "?" + "api_key=" + RIOT_API_KEY);
            log.info("URL: " + url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            conn.setDoOutput(true);
            writer = new OutputStreamWriter(conn.getOutputStream());
            writer.flush();

            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            JSONObject obj = new JSONObject(sb.toString());

            return AccountDTO.builder()
                    .userId(getPuuidDTO.getUserId())
                    .puuid(obj.getString("puuid"))
                    .gameName(obj.getString("gameName"))
                    .tagLine(obj.getString("tagLine"))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            writer.close();
            br.close();
        }
    }
}
