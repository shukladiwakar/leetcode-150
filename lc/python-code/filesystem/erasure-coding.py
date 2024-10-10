import reedsolo

def encode_data(data, k, m):
    rs = reedsolo.RSCodec(m)  # Create an RS codec with m parity symbols
    encoded_data = rs.encode(data)

    data_chunks = [encoded_data[i:i+k] for i in range(0, len(encoded_data), k)]
    return data_chunks

# Example usage:
data = b"Hello, Reed-Solomon!"
k = 4
m = 2
encoded_chunks = encode_data(data, k, m)

print(f"Encoded Data Chunks: {encoded_chunks}")