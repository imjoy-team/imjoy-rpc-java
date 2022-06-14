import asyncio
from imjoy_rpc.hypha import connect_to_server

async def start_server(server_url):
    api = await connect_to_server({"server_url": server_url})
    
    def hello(name):
        print("Hello " + name)
        return "Hello " + name

    await api.register_service({
        "name": "Hello World",
        "id": "hello-world",
        "config": {
            "visibility": "public"
        },
        "hello": hello
    })
    
    print(f"hello world service regisered at workspace: {api.config.workspace}")
    print(f"Test it with the http proxy: {server_url}/{api.config.workspace}/services/hello-world/hello?name=John")

if __name__ == "__main__":
    server_url = "http://localhost:9000" # "https://ai.imjoy.io"
    loop = asyncio.get_event_loop()
    loop.create_task(start_server(server_url))
    loop.run_forever()
