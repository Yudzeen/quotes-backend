# Quotes (Backend)
A backend service illustrating web server development which utilizes Java, Spring Framework, and MongoDB.

## API Endpoints
<table>
  <thead>
    <th>Http Method</th>
    <th>Mapping</th>
    <th>Description</th>
  </thead>
  <tbody>
    <tr>
      <td>GET</td>
      <td>/quotes</td>
      <td>Get all quotes</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/quotes/{id}</td>
      <td>Get quote by id</td>
    </tr>
    <tr>
      <td>POST</td>
      <td>/quotes</td>
      <td>Insert quote</td>
    </tr>
    <tr>
      <td>PUT</td>
      <td>/quotes</td>
      <td>Update quote</td>
    </tr>
    <tr>
      <td>DELETE</td>
      <td>/quotes</td>
      <td>Delete quote</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/quotes/random</td>
      <td>Get a random quote</td>
    </tr>
  </tbody>
</table>

All HTTP requests made should include the following header/s:
<table>
  <thead>
    <tr>
      <th>Header</th>
      <th>Description</th>
      <th>Example</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>x-api-key</td>
      <td>Api key; For authorization</td>
      <td>y2u5j6i8n0p3o8g9i</td>
    </tr>
  </tbody>
</table>

For sample requests and responses, refer to the Postman collection/s in /postman folder.
