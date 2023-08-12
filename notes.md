
### Tomcat

```yaml
server:
  tomcat:
    connection-timeout: 2s  # Time between accepting TCP connection and receiving an HTTP request (or time spend reading the HTTP body)
    keep-alive-timeout: 15s # How long to keep connection open when waiting for new HTTP request
    threads:
      max: 50 # max thread pool
      min-spare: 2
```